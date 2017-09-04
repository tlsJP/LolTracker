package com.jp.riot.api.spectator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JP on 9/3/2017.
 */
@Service
public class SpectatorClient {

    @Autowired
    RestTemplate restTemplate;


    public CurrentGameInfo getCurrentGameInfo(Long summonerId){

        return null;
    }

}
