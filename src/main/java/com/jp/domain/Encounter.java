package com.jp.domain;

import java.time.ZonedDateTime;

/**
 * Created by JP on 9/4/2017.
 */
public class Encounter {

    private Long summonerId;
    private ZonedDateTime encounterTimestamp;
    private Boolean positive;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Encounter encounter = (Encounter) o;

        if (summonerId != null ? !summonerId.equals(encounter.summonerId) : encounter.summonerId != null) return false;
        return encounterTimestamp != null ? encounterTimestamp.equals(encounter.encounterTimestamp) : encounter.encounterTimestamp == null;
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

    @Override
    public int hashCode() {
        int result = summonerId != null ? summonerId.hashCode() : 0;
        result = 31 * result + (encounterTimestamp != null ? encounterTimestamp.hashCode() : 0);
        return result;
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
