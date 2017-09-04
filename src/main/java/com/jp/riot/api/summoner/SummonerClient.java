package com.jp.riot.api.summoner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
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

//    @Scheduled(fixedRate = 10000)
    private void doGet() {
        getSummonerByName("tlsjpa");
    }

    public SummonerDto getSummonerByName(String summonerName) {


        Map<String, String> parameters = new HashMap<>();
        parameters.put("summonerName", summonerName);
        parameters.put("apiKey", apiKey);

        SummonerDto result = restTemplate.getForObject(endpoint + GET_BY_SUMMONER, SummonerDto.class, parameters);

        // This works
        //ResponseEntity<String> result = restTemplate.getForEntity("https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name/tlsjpa?api_key=RGAPI-d329a19d-6c89-4318-a7c1-bed8d182ec76", String.class);


        logger.info("{}", result);
        return result;
    }
}
