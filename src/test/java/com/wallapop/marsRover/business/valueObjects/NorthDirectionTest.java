package com.wallapop.marsRover.business.valueObjects;

import com.wallapop.marsRover.utils.Coordinate;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NorthDirectionTest {
    private NorthDirection northDirection = new NorthDirection();

    @Test
    public void turningLeftShouldReturnNorthDirection() {
        Direction newDirection = northDirection.turnLeft();

        assertEquals('w', newDirection.getCharacter());
    }

    @Test
    public void turningRightShouldReturnEastDirection() {
        Direction newDirection = northDirection.turnRight();

        assertEquals('e', newDirection.getCharacter());
    }

    @Test
    public void goingForwardShouldIncreaseY() {
        Coordinate result = northDirection.goForward(1L, 1L);
        assertEquals(1L, result.getFirst());
        assertEquals(2L, result.getSecond());
    }

    @Test
    public void goingBackwardShouldDecreaseY() {
        Coordinate result = northDirection.goBackward(1L, 1L);
        assertEquals(1L, result.getFirst());
        assertEquals(0L, result.getSecond());
    }

    @Test
    public void characterShouldBeN() {
        assertEquals('n', northDirection.getCharacter());
    }
}