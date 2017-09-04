package com.jp.riot.api.spectator;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by JP on 9/3/2017.
 */
public class CurrentGameInfo {

    private Long gameId;
    private Long gameStartTime;
    private String platformId;
    private String gameMode;
    private Long mapId;
    private String gameType;
    private Collection<BannedChampion> bannedChampions;

    private Collection<CurrentGameParticipant> participants;

    public Collection<BannedChampion> getBannedChampions() {
        if (this.bannedChampions == null) {
            this.bannedChampions = new ArrayList<>();
        }
        return bannedChampions;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public Long getGameStartTime() {
        return gameStartTime;
    }

    public String getGameType() {
        return gameType;
    }

    public Long getMapId() {
        return mapId;
    }

    public Collection<CurrentGameParticipant> getParticipants() {
        if (this.participants == null) {
            this.participants = new ArrayList<>();
        }
        return participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setBannedChampions(Collection<BannedChampion> bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public void setGameStartTime(Long gameStartTime) {
        this.gameStartTime = gameStartTime;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public void setMapId(Long mapId) {
        this.mapId = mapId;
    }

    public void setParticipants(Collection<CurrentGameParticipant> participants) {
        this.participants = participants;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }
}
