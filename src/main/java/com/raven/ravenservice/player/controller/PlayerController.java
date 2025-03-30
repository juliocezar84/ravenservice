package com.raven.ravenservice.player.controller;

import com.raven.ravenservice.player.service.PlayerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService matchService, MeterRegistry meterRegistry) {
        this.playerService = matchService;
    }
    @GetMapping("/player/{playerId}/{apiToken}")
    @CircuitBreaker(name = "playerCircuitBreaker", fallbackMethod = "getPlayer")
    public Object getPlayer(@PathVariable String playerId, @PathVariable String apiToken) throws Exception {
        return playerService.getInfo(playerId, apiToken);
    }

    public Object getPlayer(Throwable throwable) {
        Object info = "Teste!!!!!";
        return info;
    }

}