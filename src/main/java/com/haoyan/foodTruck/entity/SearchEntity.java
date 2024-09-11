package com.haoyan.foodTruck.entity;

public class SearchEntity {
    private String applicant;
    private String address;
    private String status;
    private String foodItems;
    private String facilityType;
    private String dayshours;
    private double latitude;
    private double longitude;

    public SearchEntity(String applicant, String address, String status, String foodItems, String facilityType, String dayshours, double latitude, double longitude) {
        this.applicant = applicant;
        this.address = address;
        this.status = status;
        this.foodItems = foodItems;
        this.facilityType = facilityType;
        this.dayshours = dayshours;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(String foodItems) {
        this.foodItems = foodItems;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getDayshours() {
        return dayshours;
    }

    public void setDayshours(String dayshours) {
        this.dayshours = dayshours;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "searchEntity{" +
                "applicant='" + applicant + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", foodItems='" + foodItems + '\'' +
                ", facilityType='" + facilityType + '\'' +
                ", dayshours='" + dayshours + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

}
