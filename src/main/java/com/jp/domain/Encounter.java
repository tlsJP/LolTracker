package com.jp.domain;

import java.time.ZonedDateTime;

/**
 * Created by JP on 9/4/2017.
 */
public class Encounter {


    // from CurrentGameInfo
    private Long gameId;
    private Long gameStartTime;
    private String platformId;
    private String gameMode;
    private Long mapId;
    private String gameType;

    private Boolean positive;
    private Boolean ally;
    private ZonedDateTime encounterTimestamp;

    public Boolean getAlly() {
        return ally;
    }

    public ZonedDateTime getEncounterTimestamp() {
        return encounterTimestamp;
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

    public String getPlatformId() {
        return platformId;
    }

    public Boolean getPositive() {
        return positive;
    }

    public void setAlly(Boolean ally) {
        this.ally = ally;
    }

    public void setEncounterTimestamp(ZonedDateTime encounterTimestamp) {
        this.encounterTimestamp = encounterTimestamp;
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

    public void setPositive(Boolean positive) {
        this.positive = positive;
    }
}
