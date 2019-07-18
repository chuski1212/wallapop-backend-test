package com.wallapop.marsRover.business.valueObjects;

public class DirectionFactory {
    public static Direction createDirection(Character character) {
        switch (character) {
            case 'n':
                return new NorthDirection();
            case 'w':
                return new WestDirection();
            case 'e':
                return new EastDirection();
            default:
                return new SouthDirection();
        }

    }
}
