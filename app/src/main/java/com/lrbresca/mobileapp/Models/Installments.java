package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

public class Installments {

    @SerializedName("quantity")
    private int quantity;
    @SerializedName("amount")
    private float amount;
    @SerializedName("rate")
    private float rate;
    @SerializedName("currency_id")
    private String currency_id;

    // Getter Methods

    public int getQuantity() {
        return quantity;
    }

    public float getAmount() {
        return amount;
    }

    public float getRate() {
        return rate;
    }

    public String getCurrency_id() {
        return currency_id;
    }

    // Setter Methods

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setCurrency_id(String currency_id) {
        this.currency_id = currency_id;
    }
}
