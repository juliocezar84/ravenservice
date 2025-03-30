package com.raven.ravenservice.player.entity;

import java.io.Serializable;
import java.util.List;

public class Player implements Serializable {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private List<String> names;
}
