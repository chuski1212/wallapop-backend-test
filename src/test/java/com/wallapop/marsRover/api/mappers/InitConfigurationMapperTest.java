package com.wallapop.marsRover.api.mappers;

import com.wallapop.marsRover.TestUtils;
import com.wallapop.marsRover.api.vms.InitConfigurationVM;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitConfigurationMapperTest {

    @Test
    public void initConfigurationIsMapped() {
        InitConfigurationVM initConfigurationVM = TestUtils.generateRandomInitconfiguration();

        InitConfigurationDTO result = InitConfigurationMapper.map(initConfigurationVM);

        assertEquals(initConfigurationVM.fieldXSize, result.fieldXSize);
        assertEquals(initConfigurationVM.fieldYSize, result.fieldYSize);
        assertEquals(initConfigurationVM.obstacles, result.obstacles);
        assertEquals(initConfigurationVM.roverInitialDirection, result.roverInitialDirection);
        assertEquals(initConfigurationVM.roverInitialPositionX, result.roverInitialPositionX);
        assertEquals(initConfigurationVM.roverInitialPositionY, result.roverInitialPositionY);
    }

}