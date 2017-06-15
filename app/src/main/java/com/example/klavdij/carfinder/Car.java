package com.example.klavdij.carfinder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Klavdij on 04/06/2017.
 */

public class Car implements Serializable {

    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("year")
    @Expose
    private int year;

    @SerializedName("firstRegistration")
    @Expose
    private String firstRegistration;

    @SerializedName("used")
    @Expose
    private boolean used;

    @SerializedName("mileage")
    @Expose
    private int mileage;

    @SerializedName("price")
    @Expose
    private int price;

    @SerializedName("technicalCheckupUntil")
    @Expose
    private String technicalCheckupUntil;

    @SerializedName("engineType")
    @Expose
    private String engineType;

    @SerializedName("engineVolume")
    @Expose
    private int engineVolume;

    @SerializedName("enginePower")
    @Expose
    private int power;

    @SerializedName("horsepower")
    @Expose
    private int horsePower;

    @SerializedName("manual")
    @Expose
    private boolean isManual;

    @SerializedName("colorOutside")
    @Expose
    private String colorOutside;

    @SerializedName("inside")
    @Expose
    private String inside;

    @SerializedName("locationName")
    @Expose
    private String locationName;

    @SerializedName("latitude")
    @Expose
    private String locationLatitude;

    @SerializedName("longitude")
    @Expose
    private String locationLongitude;

    @SerializedName("imageUrls")
    @Expose
    private String [] imageUrls;

    public String getManufacturer () {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFirstRegistration() {
        return firstRegistration;
    }

    public void setFirstRegistration(String firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTechnicalCheckupUntil() {
        return technicalCheckupUntil;
    }

    public void setTechnicalCheckupUntil(String technicalCheckupUntil) {
        this.technicalCheckupUntil = technicalCheckupUntil;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean manual) {
        isManual = manual;
    }

    public String getColorOutside() {
        return colorOutside;
    }

    public void setColorOutside(String colorOutside) {
        this.colorOutside = colorOutside;
    }

    public String getInside() {
        return inside;
    }

    public void setInside(String inside) {
        this.inside = inside;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationLattitude() {
        return locationLatitude;
    }

    public void setLocationLattitude(String locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public String getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(String locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String[] getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String[] imageUrls) {
        this.imageUrls = imageUrls;
    }
}
