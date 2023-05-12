package com.solvd.enums;

public enum OrderStatus {
    PENDING("Pending", 1),
    PROCESSING("Processing", 2),
    COMPLETED("Completed", 3),
    CANCELED("Canceled", 4);

    private String status;
    private int statusCode;

    OrderStatus(String status, int statusCode){
        this.status = status;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
