package com.jp.riot.api.spectator;

import com.jp.configuration.RiotConfiguration;
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
public class SpectatorClient {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RiotConfiguration riotConfiguration;

    public CurrentGameInfo getCurrentGameInfo(Long summonerId) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("summonerId", summonerId.toString());
        parameters.put("apiKey", riotConfiguration.getApiKey());

        return restTemplate.getForObject(riotConfiguration.getSpectatorApi(), CurrentGameInfo.class, parameters);

    }

}
