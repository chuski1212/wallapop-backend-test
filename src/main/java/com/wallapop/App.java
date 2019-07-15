package com.wallapop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */
@Controller
@ComponentScan("com.wallapop")
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
    }

    @RequestMapping("/")
    @ResponseBody
    public String root() {
        return "Pain puta";
    }
}
