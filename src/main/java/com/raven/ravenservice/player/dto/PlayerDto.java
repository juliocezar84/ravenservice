package com.raven.ravenservice.player.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlayerDto {
    String id;
    List<String> names;
}
