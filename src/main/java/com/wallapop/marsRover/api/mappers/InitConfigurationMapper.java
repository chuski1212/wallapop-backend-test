package com.wallapop.marsRover.api.mappers;

import com.wallapop.marsRover.api.vms.InitConfigurationVM;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;

public class InitConfigurationMapper {
    public static InitConfigurationDTO map(InitConfigurationVM initConfigurationVM) {
        InitConfigurationDTO dto = new InitConfigurationDTO();
        dto.fieldXSize = initConfigurationVM.fieldXSize;
        dto.fieldYSize = initConfigurationVM.fieldYSize;
        dto.numberOfObstacles = initConfigurationVM.numberOfObstacles;
        dto.obstacles = initConfigurationVM.obstacles;
        dto.roverInitialPositionX = initConfigurationVM.roverInitialPositionX;
        dto.roverInitialPositionY = initConfigurationVM.roverInitialPositionY;
        dto.roverInitialDirection = initConfigurationVM.roverInitialDirection;
        return dto;
    }
}
