package com.jp.db;


import com.jp.domain.Summoner;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by JP on 9/13/2017.
 */
public interface SummonerRepository extends MongoRepository<Summoner, Long>{

    Summoner findByName(String name);

}
