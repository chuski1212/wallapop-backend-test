package com.wallapop.marsRover.business.services;

import com.wallapop.marsRover.TestUtils;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.repositories.FieldRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FieldServiceTest {

    @Mock
    private FieldRepository fieldRepository;

    @InjectMocks
    private FieldService fieldService;

    @Test
    public void shouldFindField() {
        fieldService.findField();

        verify(fieldRepository).findField();
    }

    @Test
    public void shouldSaveField() throws Exception {
        Field field = TestUtils.generateRandomField();

        fieldService.save(field);

        verify(fieldRepository).save(field);
    }

    @Test
    public void shouldInitField() throws Exception {
        InitConfigurationDTO initConfigurationDTO = TestUtils.generateRandomConfigurationDTO();

        fieldService.initField(initConfigurationDTO);

        verify(fieldRepository).save(any());
    }

}