package com.wallapop.marsRover.business.valueObjects;

import com.wallapop.marsRover.utils.Coordinate;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EastDirectionTest {
    private EastDirection eastDirection = new EastDirection();

    @Test
    public void turningLeftShouldReturnNorthDirection() {
        Direction newDirection = eastDirection.turnLeft();

        assertEquals('n', newDirection.getCharacter());
    }

    @Test
    public void turningRightShouldReturnSouthDirection() {
        Direction newDirection = eastDirection.turnRight();

        assertEquals('s', newDirection.getCharacter());
    }

    @Test
    public void goingForwardShouldIncreaseX() {
        Coordinate result = eastDirection.goForward(1L, 1L);
        assertEquals(2L, result.getFirst());
        assertEquals(1L, result.getSecond());
    }

    @Test
    public void goingBackwardShouldDecreaseX() {
        Coordinate result = eastDirection.goBackward(1L, 1L);
        assertEquals(0L, result.getFirst());
        assertEquals(1L, result.getSecond());
    }

    @Test
    public void characterShouldBeE() {
        assertEquals('e', eastDirection.getCharacter());
    }
}