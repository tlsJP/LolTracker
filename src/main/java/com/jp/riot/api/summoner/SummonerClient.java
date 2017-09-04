package com.jp.riot.api.summoner;

import com.jp.domain.Summoner;
import com.jp.riot.api.league.LeagueClient;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JP on 9/3/2017.
 */
@Service
public class SummonerClient {

    private static final String GET_BY_SUMMONER = "/lol/summoner/v3/summoners/by-name/{summonerName}?api_key={apiKey}";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RestTemplate restTemplate;

    @Value("${riot.api.url.na}")
    private String endpoint;

    @Value("${riot.api.key}")
    private String apiKey;

    @Autowired
    private MapperFacade mapper;

    @Autowired
    private LeagueClient leagueClient;

    public Summoner getSummonerByName(String summonerName) {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("summonerName", summonerName);
        parameters.put("apiKey", apiKey);

        SummonerDto result = restTemplate.getForObject(endpoint + GET_BY_SUMMONER, SummonerDto.class, parameters);


        Summoner summoner = mapper.map(result, Summoner.class);

        summoner.getLeagues().addAll(leagueClient.getLeaguesBySummonerId(summoner.getId()));

        return  summoner;
    }
}
