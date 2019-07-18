package com.wallapop.marsRover.business.exceptions;

public class ObstacleEncounteredException extends Exception {
    public ObstacleEncounteredException(String obstacleMessage) {
        super(obstacleMessage);
    }
}
