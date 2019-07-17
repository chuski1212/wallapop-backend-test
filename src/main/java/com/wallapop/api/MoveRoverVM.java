package com.wallapop.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveRoverVM {
    @JsonProperty(value = "commands")
    char[] commands;
}
