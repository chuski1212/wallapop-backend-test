package com.wallapop.business;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SuppressWarnings("unchecked")
@Component
public class FieldRepository {
    private static String FIELD_FILE_PATH = "./src/main/resources/Field.json";

    public void deletePreviousFieldAndSaveNewOne(Field field) throws Exception {
        URL fieldDatabaseUrl = getClass().getClassLoader().getResource("Field.json");
        if (fieldDatabaseUrl == null) {
            throw new Exception("Field database file not found");
        }
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("field", mapToJSON(field));

        String jsonAsString = jsonObject.toJSONString();

        Path path = Paths.get(FIELD_FILE_PATH);
        Files.write(path, jsonAsString.getBytes(StandardCharsets.UTF_8));
    }

    public Field findField() throws IOException, ParseException {
        try (FileReader reader = new FileReader(FIELD_FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject fieldJSONObject = (JSONObject) jsonObject.get("field");
            return mapToField(fieldJSONObject);
        }
    }

    private JSONObject mapToJSON(Field field) {
        JSONObject result = new JSONObject();
        result.put("fieldXSize", field.getSizeX());
        result.put("fieldYSize", field.getSizeY());
        result.put("obstacles", field.getObstacles());
        result.put("roverPositionX", field.getRover().getPositionX());
        result.put("roverPositionY", field.getRover().getPositionY());
        result.put("roverDirection", field.getRover().getDirection().getCharacter().toString());
        return result;
    }

    private Field mapToField(JSONObject fieldJsonObject) {
        Field field = new Field();
        field.setSizeX((Integer) fieldJsonObject.get("fieldXSize"));
        field.setSizeY((Integer) fieldJsonObject.get("fieldYSize"));
        field.setObstacles((List<List<Integer>>) fieldJsonObject.get("obstacles"));
        field.setRover(mapToRover(fieldJsonObject));
        return field;
    }

    private Rover mapToRover(JSONObject fieldJsonObject) {
        Rover rover = new Rover();
        rover.setPositionX((Integer) fieldJsonObject.get("roverPositionX"));
        rover.setPositionY((Integer) fieldJsonObject.get("roverPositionY"));
        rover.setDirection(DirectionFactory.createDirection((Character) fieldJsonObject.get("roverDirection")));
        return rover;
    }
}
