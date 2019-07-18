package com.wallapop.marsRover.business.services;

import com.wallapop.marsRover.business.entities.Field;
import com.wallapop.marsRover.business.mappers.FieldMapper;
import com.wallapop.marsRover.business.repositories.FieldRepository;
import com.wallapop.marsRover.business.dtos.InitConfigurationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FieldService {

    private final FieldRepository fieldRepository;

    @Autowired
    FieldService(FieldRepository fieldRepository) {
        this.fieldRepository = fieldRepository;
    }

    public void initField(InitConfigurationDTO initConfigurationDTO) throws Exception {
        Field field = new Field();
        FieldMapper.map(field, initConfigurationDTO);
        fieldRepository.save(field);
    }

    public Field findField() {
        return fieldRepository.findField();
    }

    public void save(Field field) throws Exception {
        fieldRepository.save(field);
    }
}
