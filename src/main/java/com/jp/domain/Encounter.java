package com.jp.domain;

import java.time.ZonedDateTime;

/**
 * Created by JP on 9/4/2017.
 */
public class Encounter {


    private Long summonerId;
    private ZonedDateTime encounterTimestamp;
    private Boolean positive;
    private Boolean ally;

    public Encounter(Long summonerId) {
        this.summonerId = summonerId;
    }

    public Encounter(Long summonerId, ZonedDateTime encounterTimestamp) {
        this.summonerId = summonerId;
        this.encounterTimestamp = encounterTimestamp;
    }

    public Encounter() {

    }


    public Boolean getAlly() {
        return ally;
    }

    public ZonedDateTime getEncounterTimestamp() {
        return encounterTimestamp;
    }


    public Boolean getPositive() {
        return positive;
    }

    public Long getSummonerId() {
        return summonerId;
    }


    public void setAlly(Boolean ally) {
        this.ally = ally;
    }

    public void setEncounterTimestamp(ZonedDateTime encounterTimestamp) {
        this.encounterTimestamp = encounterTimestamp;
    }


    public void setPositive(Boolean positive) {
        this.positive = positive;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }
}
