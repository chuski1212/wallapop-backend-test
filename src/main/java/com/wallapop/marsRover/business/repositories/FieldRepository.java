package com.wallapop.marsRover.business.repositories;

import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.mappers.FieldMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;

@SuppressWarnings("unchecked")
@Component
public class FieldRepository {

    private InputOutputHelper inputOutputHelper;

    @Autowired
    FieldRepository(InputOutputHelper inputOutputHelper) {
        this.inputOutputHelper = inputOutputHelper;
    }

    public void save(Field field) throws Exception {
        URL fieldDatabaseUrl = getClass().getClassLoader().getResource("Field.json");
        if (fieldDatabaseUrl == null) {
            throw new FileNotFoundException("Field database file not found");
        }
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("field", FieldMapper.mapToJSON(field));

        String jsonAsString = jsonObject.toJSONString();

        inputOutputHelper.writeOnfile(jsonAsString);
    }

    public Field findField() {
        try (FileReader reader = inputOutputHelper.readFromFile()) {
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
