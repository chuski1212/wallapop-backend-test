package com.wallapop.api;

import com.wallapop.business.FieldService;
import com.wallapop.business.InitConfigurationDTO;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@ComponentScan("com.wallapop")
@EnableAutoConfiguration
@Component
public class API
{

    private final FieldService fieldService;

    @Autowired
    API(FieldService fieldService) {
        this.fieldService = fieldService;
    }

    @PostMapping("/initialize_configuration")
    public void initConfiguration(@RequestBody InitConfigurationVM initConfigurationVM) throws Exception {
        InitConfigurationDTO initConfigurationDTO = InitConfigurationMapper.map(initConfigurationVM);
        fieldService.initField(initConfigurationDTO);
    }

    @PostMapping("/move_rover")
    public void moveRover(@RequestBody MoveRoverVM moveRoverVM) throws IOException, ParseException {
        fieldService.moveRover(moveRoverVM.commands);
    }

    public static void main( String[] args )
    {
        SpringApplication.run(API.class);
    }
}
