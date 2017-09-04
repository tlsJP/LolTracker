package com.jp.com.jp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jp.riot.api.summoner.SummonerClient;
import com.jp.riot.api.summoner.SummonerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by JP on 9/3/2017.
 */
@Controller
public class GuiController {

    @Autowired
    SummonerClient summonerClient;


    @RequestMapping("/")
    public String index(Model model){
        SummonerDto response = summonerClient.getSummonerByName("tlsjpa");

        model.addAttribute("summoner", response);



        return "index";
    }

    @RequestMapping(value="/summoner",produces = "application/json")
    public @ResponseBody SummonerDto toJson(@RequestParam(value="summonerName")String summonerName){

//        ObjectMapper mapper;

        return summonerClient.getSummonerByName(summonerName);
    }
}
