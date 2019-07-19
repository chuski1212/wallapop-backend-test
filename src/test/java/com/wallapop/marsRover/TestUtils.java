package com.wallapop.marsRover;

import com.wallapop.marsRover.api.vms.InitConfigurationVM;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestUtils {
    public static InitConfigurationVM generateRandomInitconfiguration() {
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));
        InitConfigurationVM initConfigurationVM = new InitConfigurationVM();
        initConfigurationVM.fieldXSize = 3L;
        initConfigurationVM.fieldYSize = 3L;
        initConfigurationVM.obstacles = obstaclesSet;
        initConfigurationVM.roverInitialDirection = 'n';
        initConfigurationVM.roverInitialPositionX = 1L;
        initConfigurationVM.roverInitialPositionY = 1L;
        return initConfigurationVM;
    }
}
