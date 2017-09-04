package com.jp;

import com.jp.riot.api.spectator.CurrentGameInfo;
import com.jp.riot.api.spectator.SpectatorClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by JP on 9/3/2017.
 */
@Component
public class GameMonitor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SpectatorClient spectatorClient;

    @Value("${riot.tlsjpa.id}")
    private Long tlsJpaSummonerId;

    private Long currentGameId = 0L;

    @Scheduled(fixedDelay = 120000)
    private void checkForGame() {

        CurrentGameInfo currentGameInfo = spectatorClient.getCurrentGameInfo(tlsJpaSummonerId);
        if (currentGameInfo.getGameId() == null) {
            return;
        }

        if (currentGameInfo.getGameId().equals(currentGameId)) {
            logger.info("...");
            return;
        } else {
            currentGameId = currentGameInfo.getGameId();
        }

        currentGameInfo.getParticipants()
                .forEach(p -> logger.info(p.toString()));

    }
}
