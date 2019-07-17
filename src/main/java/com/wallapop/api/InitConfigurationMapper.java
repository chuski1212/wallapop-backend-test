package com.wallapop.api;

import com.wallapop.business.InitConfigurationDTO;

class InitConfigurationMapper {
    static InitConfigurationDTO map(InitConfigurationVM initConfigurationVM) {
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
