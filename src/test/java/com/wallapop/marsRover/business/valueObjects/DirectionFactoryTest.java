package com.wallapop.marsRover.business.valueObjects;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DirectionFactoryTest {

    @Test
    public void shouldCreateNorthDirection() {
        Direction result = DirectionFactory.createDirection('n');

        assertEquals('n', result.getCharacter().charValue());
    }

    @Test
    public void shouldCreateWestDirection() {
        Direction result = DirectionFactory.createDirection('w');

        assertEquals('w', result.getCharacter().charValue());
    }

    @Test
    public void shouldCreateSouthDirection() {
        Direction result = DirectionFactory.createDirection('s');

        assertEquals('s', result.getCharacter().charValue());
    }

    @Test
    public void shouldCreateEastDirection() {
        Direction result = DirectionFactory.createDirection('e');

        assertEquals('e', result.getCharacter().charValue());
    }
}