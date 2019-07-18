package com.wallapop.business;

import com.wallapop.utils.Coordinate;

interface Direction {
    Character getCharacter();
    Direction turnLeft();
    Direction turnRight();
    Coordinate goForward(Long positionX, Long positionY);
    Coordinate goBackward(Long positionX, Long positionY);
}
