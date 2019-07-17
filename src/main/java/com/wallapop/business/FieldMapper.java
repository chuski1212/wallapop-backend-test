package com.wallapop.business;

public class FieldMapper {
    public static void map(Field field, InitConfigurationDTO initConfigurationDTO) {
        field.setSizeX(initConfigurationDTO.fieldXSize);
        field.setSizeY(initConfigurationDTO.fieldYSize);
        field.setObstacles(initConfigurationDTO.obstacles);
        field.setRover(map(initConfigurationDTO));
    }

    private static Rover map(InitConfigurationDTO initConfigurationDTO) {
        Rover rover = new Rover();
        rover.setPositionX(initConfigurationDTO.roverInitialPositionX);
        rover.setPositionY(initConfigurationDTO.roverInitialPositionY);
        rover.setDirection(DirectionFactory.createDirection(initConfigurationDTO.roverInitialDirection));
        return rover;
    }
}
