package com.wallapop.marsRover.business.dtos;

import java.util.List;
import java.util.Set;

public class InitConfigurationDTO {
    public Long fieldXSize;
    public Long fieldYSize;
    public Integer numberOfObstacles;
    public Set<List<Long>> obstacles;
    public Long roverInitialPositionX;
    public Long roverInitialPositionY;
    public Character roverInitialDirection;
}
