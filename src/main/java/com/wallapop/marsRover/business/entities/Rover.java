package com.wallapop.marsRover.business.entities;

import com.wallapop.marsRover.business.exceptions.ObstacleEncounteredException;
import com.wallapop.marsRover.business.valueObjects.Direction;
import com.wallapop.marsRover.utils.Coordinate;

import java.util.List;
import java.util.Set;

public class Rover {
    private Long positionX;
    private Long positionY;
    private Direction direction;

    public Long getPositionX() {
        return positionX;
    }

    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    public Long getPositionY() {
        return positionY;
    }

    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void goForward(Long fieldXSize, Long fieldYSize, Set<List<Long>> obstacles) throws ObstacleEncounteredException {
        Coordinate nextCoordinate = direction.goForward(positionX, positionY);
        setNextCoordinateIfIsValid(nextCoordinate, fieldXSize, fieldYSize, obstacles);
    }

    public void goBackward(Long fieldXSize, Long fieldYSize, Set<List<Long>> obstacles) throws ObstacleEncounteredException {
        Coordinate nextCoordinate = direction.goBackward(positionX, positionY);
        setNextCoordinateIfIsValid(nextCoordinate, fieldXSize, fieldYSize, obstacles);
    }

    private void setNextCoordinateIfIsValid(Coordinate nextCoordinate,
                                            Long fieldXSize,
                                            Long fieldYSize,
                                            Set<List<Long>> obstacles) throws ObstacleEncounteredException {

        checkWrappingPosition(nextCoordinate, fieldXSize, fieldYSize);
        if (obstacles.contains(nextCoordinate.asList())) {
            throw new ObstacleEncounteredException(obstacleEncounteredMessage(nextCoordinate));
        }
        this.positionX = nextCoordinate.getFirst();
        this.positionY = nextCoordinate.getSecond();
    }

    private String obstacleEncounteredMessage(Coordinate nextCoordinate) {
        return String.format("Obstacle encountered at position [%s,%s]. Rover is at " +
                        "position [%s,%s] facing %s direction.",
                        nextCoordinate.getFirst(),
                        nextCoordinate.getSecond(),
                        this.positionX,
                        this.positionY,
                        this.direction.getCharacter());
    }

    private void checkWrappingPosition(Coordinate coordinate, Long fieldXSize, Long fieldYSize) {
        if (coordinate.getFirst().equals(fieldXSize)) {
            coordinate.setFirst(0);
        }
        else if (coordinate.getFirst().equals(-1L)) {
            coordinate.setFirst(fieldXSize - 1);
        }
        else if (coordinate.getSecond().equals(fieldYSize)) {
            coordinate.setSecond(0L);
        }
        else if (coordinate.getSecond().equals(-1L)) {
            coordinate.setSecond(fieldYSize - 1);
        }
    }

    public void turnLeft() {
        this.direction = this.direction.turnLeft();
    }

    public void turnRight() {
        this.direction = this.direction.turnRight();
    }
}
