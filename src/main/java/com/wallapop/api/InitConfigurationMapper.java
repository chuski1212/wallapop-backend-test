package com.wallapop.api;

import com.wallapop.business.InitConfigurationDTO;

class InitConfigurationMapper {
    static InitConfigurationDTO map(InitConfigurationVM initConfigurationVM) {
        InitConfigurationDTO dto = new InitConfigurationDTO();
        dto.mapXSize = initConfigurationVM.mapXSize;
        dto.mapYSize = initConfigurationVM.mapYSize;
        dto.numberOfObstacles = initConfigurationVM.numberOfObstacles;
        dto.obstacles = initConfigurationVM.obstacles;
        dto.roverInitialPositionX = initConfigurationVM.roverInitialPositionX;
        dto.roverInitialPositionY = initConfigurationVM.roverInitialPositionY;
        dto.roverInitialDirection = initConfigurationVM.roverInitialDirection;
        return dto;
    }
}
