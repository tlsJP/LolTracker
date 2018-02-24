package com.jp;

import com.jp.db.SummonerRepository;
import com.jp.domain.Encounter;
import com.jp.domain.Summoner;
import com.jp.riot.api.spectator.CurrentGameInfo;
import com.jp.riot.api.spectator.CurrentGameParticipant;
import com.jp.riot.api.spectator.SpectatorClient;
import com.jp.riot.api.summoner.SummonerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by JP on 9/3/2017.
 */
@Component
class GameMonitor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SummonerRepository summonerRepository;
    @Autowired
    private SpectatorClient spectatorClient;
    @Value("${riot.tlsjpa.id}")
    private Long tlsJpaSummonerId;

    private long currentGameId;

    @Autowired
    private SummonerClient summonerclient;

    private static boolean isMe(CurrentGameParticipant p) {
        return !isNotMe(p);
    }

    private static boolean isNotMe(CurrentGameParticipant p) {
        return !"tlsJPA".equals(p.getSummonerName());
    }

    @Scheduled(fixedDelay = 120000)
    private void checkForGame() {

        CurrentGameInfo currentGameInfo = spectatorClient.getCurrentGameInfo(tlsJpaSummonerId);
        if (currentGameInfo == null || currentGameInfo.getGameId() == null) {
            return;
        }

        if (currentGameInfo.getGameId().equals(currentGameId)) {
            logger.info("...");
            return;
        } else {
            currentGameId = currentGameInfo.getGameId();
            logger.info("Game found with Id : {}", currentGameId);
        }

        final ZonedDateTime now = ZonedDateTime.now();

        CurrentGameParticipant meInGame = currentGameInfo.getParticipants()
                .stream()
                .filter(GameMonitor::isMe)
                .findFirst()
                .orElse(null);

        if (meInGame == null) {
            logger.error("Why was I not in the game???");
            return;
        }

        Map<Long, Boolean> allyMap = new HashMap<>();

        // Grab all participants and find their records from the database
        // Any that are not found will have one created.
        currentGameInfo.getParticipants()
                .stream()
                .filter(GameMonitor::isNotMe)
                .peek(p -> allyMap.put(p.getSummonerId(), meInGame.getTeamId().equals(p.getTeamId())))
                .map(this::toSummoner)
                .peek(s -> {
                    Encounter e = maptoEncounter(currentGameInfo);

                    e.setAlly(allyMap.get(s.getSummonerId()));
                    e.setEncounterTimestamp(now);

                    s.getEncounters().add(e);
                })
                .forEach(summonerRepository::save);


    }

    private static Encounter maptoEncounter(CurrentGameInfo currentGameInfo) {
        Encounter e = new Encounter();

        e.setGameId(currentGameInfo.getGameId());
        e.setGameMode(currentGameInfo.getGameMode());
        e.setGameStartTime(currentGameInfo.getGameStartTime());
        e.setMapId(currentGameInfo.getMapId());
        e.setPlatformId(currentGameInfo.getPlatformId());
        return e;
    }

    private Summoner toSummoner(CurrentGameParticipant p) {
        Summoner result = summonerRepository.findOne(p.getSummonerId());
        if (result == null) {
            result = new Summoner(p.getSummonerId());
            result.setName(p.getSummonerName());
        }

        return result;
    }
}
