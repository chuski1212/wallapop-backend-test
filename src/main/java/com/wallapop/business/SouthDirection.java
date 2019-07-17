package com.wallapop.business;

import com.wallapop.utils.Coordinate;

public class SouthDirection implements Direction {
    @Override
    public Direction turnLeft() {
        return new EastDirection();
    }

    @Override
    public Direction turnRight() {
        return new WestDirection();
    }

    @Override
    public Coordinate goForward(Integer positionX, Integer positionY) {
        return new Coordinate(positionX, positionY - 1);
    }

    @Override
    public Coordinate goBackward(Integer positionX, Integer positionY) {
        return new Coordinate(positionX, positionY + 1);
    }

    @Override
    public Character getCharacter() {
        return 's';
    }

}
