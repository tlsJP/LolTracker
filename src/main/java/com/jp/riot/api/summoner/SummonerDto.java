package com.jp.riot.api.summoner;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Created by JP on 9/3/2017.
 */
public class SummonerDto {

    private String name;
    private Long summonerLevel;
    private Long id;
    private Long accountId;

    public Long getAccountId() {
        return accountId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
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
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
