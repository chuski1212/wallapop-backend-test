package com.wallapop.marsRover.utils;

import java.util.Arrays;
import java.util.List;

public class Coordinate {
    private Long first;
    private Long second;

    public Coordinate(Long first, Long second) {
        this.first = first;
        this.second = second;
    }

    public Long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public Long getSecond() {
        return second;
    }

    public void setSecond(Long second) {
        this.second = second;
    }

    public List<Long> asList() {
        return Arrays.asList(first, second);
    }
}
