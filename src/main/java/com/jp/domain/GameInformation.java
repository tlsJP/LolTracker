package com.jp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JP on 9/4/2017.
 */
public class GameInformation {

    private Long gameId;
    private Long gameStartTime;
    private String platformId;
    private String gameMode;
    private Long mapId;
    private String gameType;

    private Set<Summoner> participants;

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

    public Set<Summoner> getParticipants() {
        if (participants == null) {
            participants = new HashSet<>();
        }
        return participants;
    }

    public String getPlatformId() {
        return platformId;
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

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

}
