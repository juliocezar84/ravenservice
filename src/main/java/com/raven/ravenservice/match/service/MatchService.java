package com.raven.ravenservice.match.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MatchService {

    @Autowired
    private final RestTemplate restTemplate;

    @Value("${parameters.apiUrl}")
    private String apiUrl;
    @Value("${parameters.matchesUrl}")
    private String matchesUrl;
    public MatchService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Object getInfo(String playerId, String apiToken) throws Exception {
        Object info = null;
        String url = apiUrl + matchesUrl;
        url = url.replace("{puuid}", playerId);
        url = url.replace("{apiToken}", apiToken);
        try {
            info = restTemplate.getForObject(url, Object.class);
        } catch (Exception e) {
            System.out.println(e);
            throw new Exception("Failed to fetch info from the API");
        }
        return info;
    }

}