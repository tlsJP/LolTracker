package com.jp.riot.api.summoner;


import com.jp.domain.Summoner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Ignore
public class SummonerClientTest {

    @Autowired
    SummonerClient client;

    @Test
    public void sanity() {
        assertNotNull(client);
    }

    @Test
    public void getSummoner(){
        Summoner result = client.getSummonerByName("tlsJPA");

        assertNotNull(result);
        assertNotNull(result.getId());

    }
}
