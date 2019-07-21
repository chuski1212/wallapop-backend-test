package com.wallapop.marsRover.business.repositories;

import com.wallapop.marsRover.TestUtils;
import com.wallapop.marsRover.business.entities.Field;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FieldRepositoryTest {

    @Mock
    private InputOutputHelper inputOutputHelper;

    @InjectMocks
    private FieldRepository fieldRepository;

    @Test
    public void shouldSaveField() throws Exception {
        Field field = TestUtils.generateRandomField();

        fieldRepository.save(field);

        verify(inputOutputHelper).writeOnfile(TestUtils.generateRandomFieldAsString());
    }

    @Test
    public void shouldReadField() throws FileNotFoundException {

        when(inputOutputHelper.readFromFile()).thenAnswer(invocation -> new FileReader("./src/test/resources/TestField.json"));

        Field field = fieldRepository.findField();

        verify(inputOutputHelper).readFromFile();

        assertEquals(3L, field.getSizeX());
        assertEquals(3L, field.getSizeY());
        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));
        assertEquals(obstaclesSet, field.getObstacles());
        assertEquals(2L, field.getRover().getPositionX());
        assertEquals(2L, field.getRover().getPositionY());
        assertEquals("n", field.getRover().getDirection().getCharacter().toString());    }
}