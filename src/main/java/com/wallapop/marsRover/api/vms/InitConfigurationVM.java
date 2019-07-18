package com.wallapop.marsRover.api.vms;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class InitConfigurationVM {
    @JsonProperty(value = "fieldXSize")
    public Long fieldXSize;
    @JsonProperty(value = "fieldYSize")
    public Long fieldYSize;
    @JsonProperty(value = "numberOfObstacles")
    public Integer numberOfObstacles;
    @JsonProperty(value = "obstacles")
    public Set<List<Long>> obstacles;
    @JsonProperty(value = "roverInitialPositionX")
    public Long roverInitialPositionX;
    @JsonProperty(value = "roverInitialPositionY")
    public Long roverInitialPositionY;
    @JsonProperty(value = "roverInitialDirection")
    public Character roverInitialDirection;
}
