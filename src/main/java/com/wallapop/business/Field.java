package com.wallapop.business;

import java.util.List;

public class Field {
    private Integer sizeX;
    private Integer sizeY;
    private List<List<Integer>> obstacles;
    private Rover rover;

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
}
