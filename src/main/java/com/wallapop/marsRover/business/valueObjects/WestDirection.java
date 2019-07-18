package com.wallapop.marsRover.business.valueObjects;

import com.wallapop.marsRover.utils.Coordinate;

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
    public Coordinate goForward(Long positionX, Long positionY) {
        return new Coordinate(positionX - 1, positionY);
    }

    @Override
    public Coordinate goBackward(Long positionX, Long positionY) {
        return new Coordinate(positionX + 1, positionY);
    }

    @Override
    public Character getCharacter() {
        return 'w';
    }
}
