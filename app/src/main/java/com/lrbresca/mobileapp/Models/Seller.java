package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Seller {

    private double id;
    @SerializedName("power_seller_status")
    private String power_seller_status = null;
    @SerializedName("card_dealer")
    private boolean car_dealer;
    @SerializedName("real_estate_agency")
    private boolean real_estate_agency;
    private ArrayList<String> tags = new ArrayList<>();

    // Getter Methods
    public double getId() {
        return id;
    }

    public String getPower_seller_status() {
        return power_seller_status;
    }

    public boolean getCar_dealer() {
        return car_dealer;
    }

    public boolean getReal_estate_agency() {
        return real_estate_agency;
    }

    // Setter Methods
    public void setId(double id) {
        this.id = id;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public void setPower_seller_status(String power_seller_status) {
        this.power_seller_status = power_seller_status;
    }

    public void setCar_dealer(boolean car_dealer) {
        this.car_dealer = car_dealer;
    }

    public void setReal_estate_agency(boolean real_estate_agency) {
        this.real_estate_agency = real_estate_agency;
    }
}