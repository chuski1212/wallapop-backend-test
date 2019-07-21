package com.wallapop.marsRover.api.mappers;

import com.wallapop.marsRover.api.vms.InitConfigurationVM;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InitConfigurationMapperTest {

    @Test
    public void initConfigurationIsMapped() {
        InitConfigurationVM initConfigurationVM = new InitConfigurationVM();
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));
        initConfigurationVM.fieldXSize = 3L;
        initConfigurationVM.fieldYSize = 3L;
        initConfigurationVM.obstacles = obstaclesSet;
        initConfigurationVM.roverInitialDirection = 'n';
        initConfigurationVM.roverInitialPositionX = 1L;
        initConfigurationVM.roverInitialPositionY = 1L;

        InitConfigurationDTO result = InitConfigurationMapper.map(initConfigurationVM);

        assertEquals(initConfigurationVM.fieldXSize, result.fieldXSize);
        assertEquals(initConfigurationVM.fieldYSize, result.fieldYSize);
        assertEquals(initConfigurationVM.obstacles, result.obstacles);
        assertEquals(initConfigurationVM.roverInitialDirection, result.roverInitialDirection);
        assertEquals(initConfigurationVM.roverInitialPositionX, result.roverInitialPositionX);
        assertEquals(initConfigurationVM.roverInitialPositionY, result.roverInitialPositionY);
    }

}