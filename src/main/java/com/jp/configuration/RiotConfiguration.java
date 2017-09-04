package com.jp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JP on 9/3/2017.
 */
@Configuration
public class RiotConfiguration {

    @Autowired
    ResponseErrorHandler riotResponseErrorHandler;
    @Value("${riot.api.url.na}")
    private String endpoint;
    @Value("${riot.api.key}")
    private String apiKey;

    @Value("${riot.api.url.apiKey}")
    private String queryParameterApiKey;
    @Value("${riot.api.url.league}")
    private String leageApi;
    @Value("${riot.api.url.summoner}")
    private String summonerApi;
    @Value("${riot.api.url.spectator}")
    private String spectatorApi;

    public String getApiKey() {
        return apiKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getLeagueApi() {
        return endpoint + leageApi + queryParameterApiKey;
    }

    public String getSpectatorApi() {
        return endpoint + spectatorApi + queryParameterApiKey;
    }

    public String getSummonerApi() {
        return endpoint + summonerApi + queryParameterApiKey;
    }

    @Bean
    RestTemplate riotRestTemplate() {
        RestTemplate rt = new RestTemplate();
        rt.setErrorHandler(riotResponseErrorHandler);

        return rt;
    }


}
