package com.jp.domain;




import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JP on 9/4/2017.
 */
public class Summoner {


    private Long id;

    private String name;
    private Long summonerLevel;
    private Long accountId;
    private Set<Encounter> encounters;
    private Set<League> leagues;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Summoner summoner = (Summoner) o;

        if (id != null ? !id.equals(summoner.id) : summoner.id != null) return false;
        return accountId != null ? accountId.equals(summoner.accountId) : summoner.accountId == null;
    }

    public Long getAccountId() {
        return accountId;
    }

    public Set<Encounter> getEncounters() {
        if (encounters == null) {
            encounters = new HashSet<>();
        }
        return encounters;
    }

    public Long getId() {
        return id;
    }

    public Set<League> getLeagues() {
        if (leagues == null) {
            leagues = new HashSet<>();
        }
        return leagues;
    }

    public String getName() {
        return name;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
        return result;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }


    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
