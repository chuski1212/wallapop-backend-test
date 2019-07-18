package com.wallapop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class FieldService {

    private final FieldRepository fieldRepository;

    @Autowired
    FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public void initField(InitConfigurationDTO initConfigurationDTO) throws Exception {
        Field field = new Field();
        FieldMapper.map(field, initConfigurationDTO);
        fieldRepository.save(field);
    }

    public String moveRover(char[] commands) throws Exception {
        Field field = fieldRepository.findField();
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
            }
            catch (ObstacleEncounteredException e) {
                field.setRover(rover);
                fieldRepository.save(field);
                throw e;
            }
        }
        field.setRover(rover);
        fieldRepository.save(field);
        return generateCompleteMovementMessage(rover);
    }

    private String generateCompleteMovementMessage(Rover rover) {
        return String.format("Movement complete. Rover is at position [%s,%s], facing %s direction.",
                rover.getPositionX(),
                rover.getPositionY(),
                rover.getDirection().getCharacter());
    }
}
