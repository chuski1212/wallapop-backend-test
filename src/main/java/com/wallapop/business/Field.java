package com.wallapop.business;

import java.util.List;

public class Field {
    private Integer sizeX;
    private Integer sizeY;
    private List<List<Integer>> obstacles;
    private Rover rover;

    public Field() {}

    public Integer getSizeX() {
        return sizeX;
    }

    public void setSizeX(Integer sizeX) {
        this.sizeX = sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public void setSizeY(Integer sizeY) {
        this.sizeY = sizeY;
    }

    public List<List<Integer>> getObstacles() {
        return obstacles;
    }

    public void setObstacles(List<List<Integer>> obstacles) {
        this.obstacles = obstacles;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }
}
