package com.jp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by JP on 9/3/2017.
 */
@SpringBootApplication
@EnableScheduling
public class LolTracker {


    public static void main(String[] args) {
        SpringApplication.run(LolTracker.class);

    }
}
