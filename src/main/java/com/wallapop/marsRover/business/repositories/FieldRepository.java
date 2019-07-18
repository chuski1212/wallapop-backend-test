package com.wallapop.marsRover.business.repositories;

import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.mappers.FieldMapper;
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

@SuppressWarnings("unchecked")
@Component
public class FieldRepository {
    private static String FIELD_FILE_PATH = "./src/main/resources/Field.json";

    public void save(Field field) throws Exception {
        URL fieldDatabaseUrl = getClass().getClassLoader().getResource("Field.json");
        if (fieldDatabaseUrl == null) {
            throw new FileNotFoundException("Field database file not found");
        }
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("field", FieldMapper.mapToJSON(field));

        String jsonAsString = jsonObject.toJSONString();

        Path path = Paths.get(FIELD_FILE_PATH);
        Files.write(path, jsonAsString.getBytes(StandardCharsets.UTF_8));
    }

    public Field findField() {
        try (FileReader reader = new FileReader(FIELD_FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONObject fieldJSONObject = (JSONObject) jsonObject.get("field");
            return fieldJSONObject == null ? null : FieldMapper.mapToField(fieldJSONObject);
        }
        catch (IOException|ParseException e) {
            return null;
        }
    }
}
