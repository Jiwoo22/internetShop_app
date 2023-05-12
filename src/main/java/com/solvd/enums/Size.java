package com.solvd.enums;

public enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L");

    private String size;

    Size(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }
}
