package com.wallapop.marsRover.business.mappers;

import com.wallapop.marsRover.TestUtils;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import com.wallapop.marsRover.business.entities.Field;
import org.json.simple.JSONObject;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FieldMapperTest {

    @Test
    public void mapInitConfigurationToField() {
        Field field = new Field();

        InitConfigurationDTO initConfigurationDTO = TestUtils.generateRandomConfigurationDTO();
        FieldMapper.map(field, initConfigurationDTO);

        assertEquals(field.getSizeX(), initConfigurationDTO.fieldXSize);
        assertEquals(field.getSizeY(), initConfigurationDTO.fieldYSize);
        assertEquals(field.getObstacles(), initConfigurationDTO.obstacles);
        assertEquals(field.getRover().getPositionX(), initConfigurationDTO.roverInitialPositionX);
        assertEquals(field.getRover().getPositionY(), initConfigurationDTO.roverInitialPositionY);
        assertEquals(field.getRover().getDirection().getCharacter(), initConfigurationDTO.roverInitialDirection);
    }

    @Test
    public void mapFieldToJSONObject() {
        Field field = TestUtils.generateRandomField();

        JSONObject result = FieldMapper.mapToJSON(field);

        assertEquals(field.getSizeX(), result.get("fieldXSize"));
        assertEquals(field.getSizeY(), result.get("fieldYSize"));
        assertEquals(field.getObstacles(), result.get("obstacles"));
        assertEquals(field.getRover().getPositionX(), result.get("roverPositionX"));
        assertEquals(field.getRover().getPositionY(), result.get("roverPositionY"));
        assertEquals(field.getRover().getDirection().getCharacter().toString(), result.get("roverDirection"));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void mapJSONToField() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("fieldXSize", 3L);
        jsonObject.put("fieldYSize", 3L);
        List<List<Long>> obstacles = Collections.singletonList(Arrays.asList(1L, 1L));
        jsonObject.put("obstacles", obstacles);
        jsonObject.put("roverPositionX", 2L);
        jsonObject.put("roverPositionY", 2L);
        jsonObject.put("roverDirection", "n");

        Field result = FieldMapper.mapToField(jsonObject);

        Set<List<Long>> obstaclesSet = new HashSet<>();
        obstaclesSet.add(Arrays.asList(1L, 1L));

        assertEquals(jsonObject.get("fieldXSize"), result.getSizeX());
        assertEquals(jsonObject.get("fieldYSize"), result.getSizeY());
        assertEquals(obstaclesSet, result.getObstacles());
        assertEquals(jsonObject.get("roverPositionX"), result.getRover().getPositionX());
        assertEquals(jsonObject.get("roverPositionY"), result.getRover().getPositionY());
        assertEquals('n', result.getRover().getDirection().getCharacter());
    }
}