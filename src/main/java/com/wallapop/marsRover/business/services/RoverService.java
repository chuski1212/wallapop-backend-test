package com.wallapop.marsRover.business.services;

import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.entities.Rover;
import com.wallapop.marsRover.business.exceptions.FieldNotInitializedException;
import com.wallapop.marsRover.business.exceptions.ObstacleEncounteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoverService {

    private final FieldService fieldService;

    @Autowired
    RoverService(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    public String moveRover(char[] commands) throws Exception {
        Field field = fieldService.findField();
        if (field == null) {
            throw new FieldNotInitializedException("Field has not been initialized.");
        }
        Long fieldSizeX = field.getSizeX();
        Long fieldSizeY = field.getSizeY();
        Set<List<Long>> obstacles = field.getObstacles();
        Rover rover = field.getRover();
        for (char command : commands) {
            try {
                switch (command) {
                    case 'f':
                        rover.goForward(fieldSizeX, fieldSizeY, obstacles);
                        break;
                    case 'b':
                        rover.goBackward(fieldSizeX, fieldSizeY, obstacles);
                        break;
                    case 'l':
                        rover.turnLeft();
                        break;
                    default:
                        rover.turnRight();
                        break;
                }
            } catch (ObstacleEncounteredException e) {
                field.setRover(rover);
                fieldService.save(field);
                throw e;
            }
        }
        field.setRover(rover);
        fieldService.save(field);
        return generateCompleteMovementMessage(rover);
    }

    private String generateCompleteMovementMessage(Rover rover) {
        return String.format("Movement complete. Rover is at position [%s,%s], facing %s direction.",
                rover.getPositionX(),
                rover.getPositionY(),
                rover.getDirection().getCharacter());
    }
}

