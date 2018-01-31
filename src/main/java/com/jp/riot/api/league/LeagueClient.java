package com.jp.riot.api.league;

import com.jp.configuration.RiotConfiguration;
import com.jp.domain.League;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by JP on 9/4/2017.
 */
@Service
public class LeagueClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RiotConfiguration riotConfiguration;

    @Autowired
    private MapperFacade mapper;


    public Set<League> getLeaguesBySummonerId(Long summonerId) {
        logger.info("getLeaguesBySummonerId({})", summonerId);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("summonerId", summonerId.toString());
        parameters.put("apiKey", riotConfiguration.getApiKey());

        LeaguePositionDto[] leagues = restTemplate.getForEntity(riotConfiguration.getLeagueApi(), LeaguePositionDto[].class, parameters).getBody();

        List<League> mappedLeagues = mapper.mapAsList(Arrays.stream(leagues).collect(Collectors.toList()), League.class);

        Set<League> leagueSet = new HashSet<>(mappedLeagues);

        logger.debug("{}", leagueSet);

        return leagueSet;
    }
}
