package com.wallapop.marsRover.business.mappers;

import com.wallapop.marsRover.business.valueObjects.DirectionFactory;
import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.entities.Rover;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import org.json.simple.JSONObject;

import java.util.HashSet;
import java.util.List;

@SuppressWarnings("unchecked")
public class FieldMapper {
    public static void map(Field field, InitConfigurationDTO initConfigurationDTO) {
        field.setSizeX(initConfigurationDTO.fieldXSize);
        field.setSizeY(initConfigurationDTO.fieldYSize);
        field.setObstacles(initConfigurationDTO.obstacles);
        field.setRover(map(initConfigurationDTO));
    }

    private static Rover map(InitConfigurationDTO initConfigurationDTO) {
        Rover rover = new Rover();
        rover.setPositionX(initConfigurationDTO.roverInitialPositionX);
        rover.setPositionY(initConfigurationDTO.roverInitialPositionY);
        rover.setDirection(DirectionFactory.createDirection(initConfigurationDTO.roverInitialDirection));
        return rover;
    }

    public static JSONObject mapToJSON(Field field) {
        JSONObject result = new JSONObject();
        result.put("fieldXSize", field.getSizeX());
        result.put("fieldYSize", field.getSizeY());
        result.put("obstacles", field.getObstacles());
        result.put("roverPositionX", field.getRover().getPositionX());
        result.put("roverPositionY", field.getRover().getPositionY());
        result.put("roverDirection", field.getRover().getDirection().getCharacter().toString());
        return result;
    }

    public static Field mapToField(JSONObject fieldJsonObject) {
        Field field = new Field();
        field.setSizeX((Long) fieldJsonObject.get("fieldXSize"));
        field.setSizeY((Long) fieldJsonObject.get("fieldYSize"));
        field.setObstacles(new HashSet<>((List<List<Long>>) fieldJsonObject.get("obstacles")));
        field.setRover(mapToRover(fieldJsonObject));
        return field;
    }

    private static Rover mapToRover(JSONObject fieldJsonObject) {
        Rover rover = new Rover();
        rover.setPositionX((Long) fieldJsonObject.get("roverPositionX"));
        rover.setPositionY((Long) fieldJsonObject.get("roverPositionY"));
        rover.setDirection(DirectionFactory.createDirection(((String) fieldJsonObject.get("roverDirection")).charAt(0)));
        return rover;
    }
}
