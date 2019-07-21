package com.wallapop.marsRover;

import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.entities.Rover;
import com.wallapop.marsRover.business.valueObjects.NorthDirection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {
    public static Field generateRandomField() {
        Field field = new Field();
        field.setSizeX(3L);
        field.setSizeY(3L);
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));
        field.setObstacles(obstaclesSet);
        Rover rover = new Rover();
        rover.setPositionX(2L);
        rover.setPositionY(2L);
        rover.setDirection(new NorthDirection());
        field.setRover(rover);
        return field;
    }

    public static String generateRandomFieldAsString() {
        return "{\"field\":{\"obstacles\":[[1, 1]],\"roverPositionY\":2,\"fieldYSize\":3,\"roverPositionX\":2,\"fieldXSize\":3,\"roverDirection\":\"n\"}}";
    }

    public static InitConfigurationDTO generateRandomConfigurationDTO() {
        InitConfigurationDTO initConfigurationDTO = new InitConfigurationDTO();
        initConfigurationDTO.fieldXSize = 3L;
        initConfigurationDTO.fieldYSize = 3L;
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));
        initConfigurationDTO.obstacles = obstaclesSet;
        initConfigurationDTO.roverInitialDirection = 'n';
        initConfigurationDTO.roverInitialPositionX = 2L;
        initConfigurationDTO.roverInitialPositionY = 2L;
        return  initConfigurationDTO;
    }
}
