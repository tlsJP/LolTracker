package com.jp.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by JP on 9/4/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Summoner {



    private String name;
    private Long summonerId;
    private Long summonerLevel;
    private Long accountId;
    private Set<Encounter> encounters;
    private Set<League> leagues;

    public Summoner(Long summonerId) {
        this.summonerId = summonerId;
    }

    public Summoner() {

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



    public Set<League> getLeagues() {
        if (leagues == null) {
            leagues = new HashSet<>();
        }
        return leagues;
    }

    public String getName() {
        return name;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }



    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
