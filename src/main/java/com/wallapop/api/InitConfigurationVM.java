package com.wallapop.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class InitConfigurationVM {
    @JsonProperty(value = "fieldXSize")
    Integer fieldXSize;
    @JsonProperty(value = "fieldYSize")
    Integer fieldYSize;
    @JsonProperty(value = "numberOfObstacles")
    Integer numberOfObstacles;
    @JsonProperty(value = "obstacles")
    List<List<Integer>> obstacles;
    @JsonProperty(value = "roverInitialPositionX")
    Integer roverInitialPositionX;
    @JsonProperty(value = "roverInitialPositionY")
    Integer roverInitialPositionY;
    @JsonProperty(value = "roverInitialDirection")
    Character roverInitialDirection;
}
