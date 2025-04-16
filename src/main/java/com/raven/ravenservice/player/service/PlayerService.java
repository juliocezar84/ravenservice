package com.raven.ravenservice.player.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerService {
    Logger logger = LoggerFactory.getLogger(PlayerService.class);
    @Autowired
    private final RestTemplate restTemplate;
    @Value("${parameters.apiUrl}")
    private String apiUrl;
    @Value("${parameters.playerUrl}")
    private String playerUrl;
    public PlayerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getInfo(String playerId, String apiToken) throws Exception {
        Object info = null;
        String url = apiUrl + playerUrl;
        url = url.replace("{puuid}", playerId);
        url = url.replace("{apiToken}", apiToken);
        try {
            info = restTemplate.getForObject(url, Object.class);
        } catch (Exception e) {
            logger.error(String.valueOf(e));
            throw e;
        }
        return info;
    }

}