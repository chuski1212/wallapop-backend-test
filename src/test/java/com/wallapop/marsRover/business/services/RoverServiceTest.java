package com.wallapop.marsRover.business.services;

import com.wallapop.marsRover.TestUtils;
import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.exceptions.FieldNotInitializedException;
import com.wallapop.marsRover.business.exceptions.ObstacleEncounteredException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class RoverServiceTest {
    @Mock
    private FieldService fieldService;

    @InjectMocks
    private RoverService roverService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void shouldThrowFieldNotInitializedExceptionIfTheFieldIsNotInitialized() throws Exception {
        char[] commands = "fff".toCharArray();

        when(fieldService.findField()).thenReturn(null);
        thrown.expect(FieldNotInitializedException.class);

        roverService.moveRover(commands);
    }

    @Test
    public void shouldMoveRoverWithoutObstacle() throws Exception {
        char[] commands = "flbr".toCharArray();
        Field field = TestUtils.generateRandomField();

        when(fieldService.findField()).thenReturn(field);

        String result = roverService.moveRover(commands);

        assertEquals("Movement complete. Rover is at position [0,0], facing n direction.",
                result);

    }

    @Test
    public void shouldMoveRoverWithObstacle() throws Exception {
        char[] commands = "flfrf".toCharArray();
        Field field = TestUtils.generateRandomField();

        when(fieldService.findField()).thenReturn(field);
        thrown.expect(ObstacleEncounteredException.class);
        thrown.expectMessage("Obstacle encountered at position [1,1]. Rover is at position [1,0] facing n direction.");

        roverService.moveRover(commands);
    }
}