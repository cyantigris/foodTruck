package com.haoyan.foodTruck.entity.dto;

public class RequestDTO {
    private long distance;

    private String applicant;

    private String truckStatus;

    private String facilityType;

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getApplication() {
        return applicant;
    }

    public void setApplication(String applicant) {
        this.applicant = applicant;
    }

    public String getTruckStatus() {
        return truckStatus;
    }

    public void setTruckStatus(String truckStatus) {
        this.truckStatus = truckStatus;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }
}
