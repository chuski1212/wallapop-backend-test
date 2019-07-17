package com.wallapop.business;

import com.wallapop.utils.Coordinate;

interface Direction {
    Character getCharacter();
    Direction turnLeft();
    Direction turnRight();
    Coordinate goForward(Integer positionX, Integer positionY);
    Coordinate goBackward(Integer positionX, Integer positionY);
}
