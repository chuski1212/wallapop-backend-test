package com.wallapop.marsRover.api.vms;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveRoverVM {
    @JsonProperty(value = "commands")
    public
    char[] commands;
}
