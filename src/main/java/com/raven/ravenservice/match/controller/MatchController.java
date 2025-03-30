package com.raven.ravenservice.match.controller;

import com.raven.ravenservice.match.service.MatchService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {


    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("/matches/{playerId}/{apiToken}")
    @CircuitBreaker(name = "matchCircuitBreaker", fallbackMethod = "getMatch")
    public Object getMatch(@PathVariable String playerId, @PathVariable String apiToken) throws Exception {
        return matchService.getInfo(playerId, apiToken);
    }

    public Object getMatch(Throwable throwable) {
        Object info = "Service unavailable!";
        return info;
    }

}