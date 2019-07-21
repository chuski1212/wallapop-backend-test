package com.wallapop.marsRover.business.valueObjects;

import com.wallapop.marsRover.utils.Coordinate;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SouthDirectionTest {
    private SouthDirection southDirection = new SouthDirection();

    @Test
    public void turningLeftShouldReturnEastDirection() {
        Direction newDirection = southDirection.turnLeft();

        assertEquals('e', newDirection.getCharacter());
    }

    @Test
    public void turningRightShouldReturnWestDirection() {
        Direction newDirection = southDirection.turnRight();

        assertEquals('w', newDirection.getCharacter());
    }

    @Test
    public void goingForwardShouldDecreaseY() {
        Coordinate result = southDirection.goForward(1L, 1L);
        assertEquals(1L, result.getFirst());
        assertEquals(0L, result.getSecond());
    }

    @Test
    public void goingBackwardShouldIncreaseY() {
        Coordinate result = southDirection.goBackward(1L, 1L);
        assertEquals(1L, result.getFirst());
        assertEquals(2L, result.getSecond());
    }

    @Test
    public void characterShouldBeS() {
        assertEquals('s', southDirection.getCharacter());
    }


}