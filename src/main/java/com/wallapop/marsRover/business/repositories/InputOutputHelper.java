package com.wallapop.marsRover.business.repositories;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Auxiliary class to be able to test the Repository easily */

@Component
public class InputOutputHelper {
    private String FIELD_FILE_PATH = "./src/main/resources/Field.json";

    public void writeOnfile(String output) throws IOException {
        Path path = Paths.get(FIELD_FILE_PATH);
        Files.write(path, output.getBytes(StandardCharsets.UTF_8));
    }

    public FileReader readFromFile() throws FileNotFoundException {
        return new FileReader(FIELD_FILE_PATH);
    }
}
