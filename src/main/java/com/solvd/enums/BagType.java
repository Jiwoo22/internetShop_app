package com.solvd.enums;

public enum BagType {
    BACKPACK("Backpack"),
    HANDBAG("Handbag"),
    DUFFLE("Duffle Bag"),
    MESSENGER("Messenger Bag"),
    TOTE("Tote Bag");

    private String type;

    BagType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
