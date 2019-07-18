package com.wallapop.business;

import com.wallapop.utils.Coordinate;

public class NorthDirection implements Direction {

    @Override
    public Direction turnLeft() {
        return new WestDirection();
    }

    @Override
    public Direction turnRight() {
        return new EastDirection();
    }

    @Override
    public Coordinate goForward(Long positionX, Long positionY) {
        return new Coordinate(positionX, positionY + 1);
    }

    @Override
    public Coordinate goBackward(Long positionX, Long positionY) {
        return new Coordinate(positionX, positionY - 1);
    }

    @Override
    public Character getCharacter() {
        return 'n';
    }
}
