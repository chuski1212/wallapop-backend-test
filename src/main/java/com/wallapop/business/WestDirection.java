package com.wallapop.business;

import com.wallapop.utils.Coordinate;

public class WestDirection implements Direction {
    @Override
    public Direction turnLeft() {
        return new SouthDirection();
    }

    @Override
    public Direction turnRight() {
        return new NorthDirection();
    }

    @Override
    public Coordinate goForward(Integer positionX, Integer positionY) {
        return new Coordinate(positionX - 1, positionY);
    }

    @Override
    public Coordinate goBackward(Integer positionX, Integer positionY) {
        return new Coordinate(positionX + 1, positionY);
    }

    @Override
    public Character getCharacter() {
        return 'w';
    }
}
