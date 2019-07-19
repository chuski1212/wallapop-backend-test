package com.wallapop.marsRover.business.entities;

import com.wallapop.marsRover.business.exceptions.ObstacleEncounteredException;
import com.wallapop.marsRover.business.valueObjects.NorthDirection;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void moveChangePositionToUpperCoordinate() throws ObstacleEncounteredException {
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));

        Rover rover = new Rover();
        rover.setPositionX(0L);
        rover.setPositionY(0L);
        rover.setDirection(new NorthDirection());

        rover.goForward(2L, 2L, obstaclesSet);

        assertEquals(0L, rover.getPositionX());
        assertEquals(1L, rover.getPositionY());
    }

    @Test
    public void moveChangePositionWrappingToOppositeSideUpToDown() throws ObstacleEncounteredException {
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));

        Rover rover = new Rover();
        rover.setPositionX(0L);
        rover.setPositionY(1L);
        rover.setDirection(new NorthDirection());

        rover.goForward(2L, 2L, obstaclesSet);

        assertEquals(0L, rover.getPositionX());
        assertEquals(0L, rover.getPositionY());
    }

    @Test
    public void moveChangePositionWrappingToOppositeSideDownToUp() throws ObstacleEncounteredException {
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));

        Rover rover = new Rover();
        rover.setPositionX(0L);
        rover.setPositionY(0L);
        rover.setDirection(new NorthDirection());

        rover.goBackward(2L, 2L, obstaclesSet);

        assertEquals(0L, rover.getPositionX());
        assertEquals(1L, rover.getPositionY());
    }

    @Test
    public void moveFindsObstacle() throws ObstacleEncounteredException {
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(0L, 1L));

        Rover rover = new Rover();
        rover.setPositionX(0L);
        rover.setPositionY(0L);
        rover.setDirection(new NorthDirection());

        thrown.expect(ObstacleEncounteredException.class);

        rover.goForward(2L, 2L, obstaclesSet);
    }

}