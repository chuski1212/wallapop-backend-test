package com.wallapop.business;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FieldService {

    private final FieldRepository fieldRepository;

    @Autowired
    FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public void initField(InitConfigurationDTO initConfigurationDTO) throws Exception {
        Field field = new Field();
        FieldMapper.map(field, initConfigurationDTO);
        fieldRepository.deletePreviousFieldAndSaveNewOne(field);
    }

    public Field findField() throws IOException, ParseException {
        return fieldRepository.findField();
    }

    public void moveRover(char[] commands) throws IOException, ParseException {
        Field field = fieldRepository.findField();
        for (char command : commands) {
            switch (command) {
                case 'f':
                    //field.getRover().getDirection().goForward();
            }
        }
    }
}
