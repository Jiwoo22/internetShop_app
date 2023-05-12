package com.solvd.enums;

public enum Color {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    WHITE("White"),
    BLACK("Black");

    private String color;

    Color (String color) {
        this.color = color;
    }

    public String getColor () {
        return color;
    }
}
