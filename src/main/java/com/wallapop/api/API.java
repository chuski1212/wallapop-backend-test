package com.wallapop.api;

import com.wallapop.business.InitConfigurationDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@RestController
@ComponentScan("com.wallapop")
@EnableAutoConfiguration
public class API
{
    public static void main( String[] args )
    {
        SpringApplication.run(API.class);
    }

    @GetMapping("/")
    @ResponseBody
    public String root() {
        return "Hello World";
    }

    @PostMapping("/initialize_configuration")
    public void initConfiguration(@RequestBody InitConfigurationVM initConfigurationVM) {
        InitConfigurationDTO initConfigurationDTO = InitConfigurationMapper.map(initConfigurationVM);
        System.out.println("post received");
    }
}
