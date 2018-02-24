package com.jp.riot.api.summoner;

import com.jp.configuration.RiotConfiguration;
import com.jp.domain.Summoner;
import com.jp.riot.api.league.LeagueClient;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JP on 9/3/2017.
 */
@Service
public class SummonerClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RiotConfiguration riotConfiguration;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MapperFacade mapper;

    @Autowired
    private LeagueClient leagueClient;

    public Summoner getSummonerByName(String summonerName) {
        logger.info("getSummonerByName({})", summonerName);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("summonerName", summonerName);
        parameters.put("apiKey", riotConfiguration.getApiKey());

        SummonerDto result = restTemplate.getForObject(riotConfiguration.getSummonerApi(), SummonerDto.class, parameters);

        Summoner summoner = mapper.map(result, Summoner.class);

        summoner.getLeagues().addAll(leagueClient.getLeaguesBySummonerId(summoner.getSummonerId()));

        logger.debug("{}", summoner);

        return summoner;
    }
}
