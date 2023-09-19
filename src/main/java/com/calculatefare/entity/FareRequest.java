package com.calculatefare.entity;

public class FareRequest {

    private String fromLocation;
    private String toLocation;
    private String cabType;

    public FareRequest() {
    }

    public FareRequest(String fromLocation, String toLocation, String cabType) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.cabType = cabType;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getCabType() {
        return cabType;
    }

    public void setCabType(String cabType) {
        this.cabType = cabType;
    }

    @Override
    public String toString() {
        return "FareRequest [fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", cabType=" + cabType + "]";
    }
}
