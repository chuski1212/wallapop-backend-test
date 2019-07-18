package com.wallapop.marsRover.business.valueObjects;

import com.wallapop.marsRover.utils.Coordinate;

public interface Direction {
    Character getCharacter();
    Direction turnLeft();
    Direction turnRight();
    Coordinate goForward(Long positionX, Long positionY);
    Coordinate goBackward(Long positionX, Long positionY);
}
