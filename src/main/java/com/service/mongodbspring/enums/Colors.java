package com.service.mongodbspring.enums;

import lombok.Getter;

import static com.service.mongodbspring.constants.PathConstants.*;

@Getter
public enum Colors {
    RED(COLOR_RED),
    BLUE(COLOR_BLUE),
    PINK(COLOR_PINK),
    WHITE(COLOR_WHITE),
    BLACK(COLOR_BLACK);

    private final String name;
    Colors(String name) {
        this.name = name;
    }
}
