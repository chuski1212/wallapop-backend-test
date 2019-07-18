package com.wallapop.business;

import java.util.List;
import java.util.Set;

public class Field {
    private Long sizeX;
    private Long sizeY;
    private Set<List<Long>> obstacles;
    private Rover rover;

    public Field() {}

    public Long getSizeX() {
        return sizeX;
    }

    public void setSizeX(Long sizeX) {
        this.sizeX = sizeX;
    }

    public Long getSizeY() {
        return sizeY;
    }

    public void setSizeY(Long sizeY) {
        this.sizeY = sizeY;
    }

    public Set<List<Long>> getObstacles() {
        return obstacles;
    }

    public void setObstacles(Set<List<Long>> obstacles) {
        this.obstacles = obstacles;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
