package com.jp.riot.api.spectator;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by JP on 9/3/2017.
 */
public class CurrentGameParticipant {

    private Long championId;
    private String summonerName;
    private Long teamId;
    private Long summonerId;

    public Long getChampionId() {
        return championId;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
