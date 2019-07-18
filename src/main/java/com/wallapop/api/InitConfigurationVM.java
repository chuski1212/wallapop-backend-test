package com.wallapop.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

class InitConfigurationVM {
    @JsonProperty(value = "fieldXSize")
    Long fieldXSize;
    @JsonProperty(value = "fieldYSize")
    Long fieldYSize;
    @JsonProperty(value = "numberOfObstacles")
    Integer numberOfObstacles;
    @JsonProperty(value = "obstacles")
    Set<List<Long>> obstacles;
    @JsonProperty(value = "roverInitialPositionX")
    Long roverInitialPositionX;
    @JsonProperty(value = "roverInitialPositionY")
    Long roverInitialPositionY;
    @JsonProperty(value = "roverInitialDirection")
    Character roverInitialDirection;
}
