package com.wallapop.api;

import com.wallapop.business.FieldNotInitializedException;
import com.wallapop.business.FieldService;
import com.wallapop.business.InitConfigurationDTO;
import com.wallapop.business.ObstacleEncounteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity initConfiguration(@RequestBody InitConfigurationVM initConfigurationVM) {
        try {
            InitConfigurationDTO initConfigurationDTO = InitConfigurationMapper.map(initConfigurationVM);
            fieldService.initField(initConfigurationDTO);
            return ResponseEntity.status(200).body("Initialization completed.");
        }
        catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/move_rover")
    public ResponseEntity moveRover(@RequestBody MoveRoverVM moveRoverVM) throws Exception {
        String message;
        try {
            message = fieldService.moveRover(moveRoverVM.commands);
        }
        catch (FieldNotInitializedException e) {
            return ResponseEntity.status(409).body(e.getMessage());
        }
        catch (ObstacleEncounteredException e) {
            return ResponseEntity.status(200).body(e.getMessage());
        }
        return ResponseEntity.status(200).body(message);
    }

    public static void main( String[] args )
    {
        SpringApplication.run(API.class);
    }
}
