package com.jp.riot.api.league;

/**
 * Created by JP on 9/4/2017.
 */
public class LeaguePositionDto {

    private String queueType;
    private String tier;
    private String rank;
    private Integer leaguePoints;
    private String leagueName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaguePositionDto league = (LeaguePositionDto) o;

        if (queueType != null ? !queueType.equals(league.queueType) : league.queueType != null) return false;
        return leagueName != null ? leagueName.equals(league.leagueName) : league.leagueName == null;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public Integer getLeaguePoints() {
        return leaguePoints;
    }

    public String getQueueType() {
        return queueType;
    }

    public String getRank() {
        return rank;
    }

    public String getTier() {
        return tier;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setLeaguePoints(Integer leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }
}
