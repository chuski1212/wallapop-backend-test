package com.wallapop.business;

import com.wallapop.utils.Coordinate;

public class EastDirection implements Direction {
    @Override
    public Direction turnLeft() {
        return new NorthDirection();
    }

    @Override
    public Direction turnRight() {
        return new SouthDirection();
    }

    @Override
    public Coordinate goForward(Long positionX, Long positionY) {
        return new Coordinate(positionX + 1, positionY);
    }

    @Override
    public Coordinate goBackward(Long positionX, Long positionY) {
        return new Coordinate(positionX - 1, positionY);
    }

    @Override
    public Character getCharacter() {
        return 'e';
    }
}
