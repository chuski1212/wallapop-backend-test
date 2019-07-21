package com.wallapop.marsRover.business.valueObjects;

import com.wallapop.marsRover.utils.Coordinate;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WestDirectionTest {
    private WestDirection westDirection = new WestDirection();

    @Test
    public void turningLeftShouldReturnSouthDirection() {
        Direction newDirection = westDirection.turnLeft();

        assertEquals('s', newDirection.getCharacter());
    }

    @Test
    public void turningRightShouldReturnNorthDirection() {
        Direction newDirection = westDirection.turnRight();

        assertEquals('n', newDirection.getCharacter());
    }

    @Test
    public void goingForwardShouldDecreaseX() {
        Coordinate result = westDirection.goForward(1L, 1L);
        assertEquals(0L, result.getFirst());
        assertEquals(1L, result.getSecond());
    }

    @Test
    public void goingBackwardShouldIncreaseX() {
        Coordinate result = westDirection.goBackward(1L, 1L);
        assertEquals(2L, result.getFirst());
        assertEquals(1L, result.getSecond());
    }

    @Test
    public void characterShouldBeW() {
        assertEquals('w', westDirection.getCharacter());
    }}