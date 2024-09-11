package com.haoyan.foodTruck.entity;

public class TruckDO {
    private Long applicantID;
    private String applicant;
    private String locationDescription;
    private String address;
    private String status;
    private String foodItems;
    private String facilityType;
    private String dayhours;
    private double latitude;
    private double longitude;
    private int firePreventionDistricts;
    private int policeDistricts;
    private int zipCode;
    private int neighborhoods;

    private boolean flag = false;

    public Long getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Long applicantID) {
        this.applicantID = applicantID;
    }

    public String getDayhours() {
        return dayhours;
    }

    public void setDayhours(String dayhours) {
        this.dayhours = dayhours;
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

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
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

    public int getFirePreventionDistricts() {
        return firePreventionDistricts;
    }

    public void setFirePreventionDistricts(int firePreventionDistricts) {
        this.firePreventionDistricts = firePreventionDistricts;
    }

    public int getPoliceDistricts() {
        return policeDistricts;
    }

    public void setPoliceDistricts(int policeDistricts) {
        this.policeDistricts = policeDistricts;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getNeighborhoods() {
        return neighborhoods;
    }

    public void setNeighborhoods(int neighborhoods) {
        this.neighborhoods = neighborhoods;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TruckDO{" +
                "applicantID=" + applicantID +
                ", applicant='" + applicant + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", foodItems='" + foodItems + '\'' +
                ", facilityType='" + facilityType + '\'' +
                ", dayhours='" + dayhours + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", firePreventionDistricts=" + firePreventionDistricts +
                ", policeDistricts=" + policeDistricts +
                ", zipCode=" + zipCode +
                ", neighborhoods=" + neighborhoods +
                '}';
    }
}
