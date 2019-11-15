package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Body {

    @SerializedName("id")
    private String idProduct;

    @SerializedName("site_id")
    private String siteId;

    private String title;

    private String price;

    @SerializedName("base_Price")
    private String basePrice;

    @SerializedName("currency_id")
    private String currencyId;

    @SerializedName("available_quantity")
    private int availableQuantity;

    @SerializedName("sold_quantity")
    private int soldQuantity;

    private String condition;

    private String thumbnail;

    private List<Picture> pictures;

    private List<Attributes> attributes;

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Picture> getPictures(){
      return pictures;
    }

    public void setPictures(List<Picture> pictures){
       this.pictures = pictures;
    }

    public List<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attributes> attributes) {
        this.attributes = attributes;
    }
}
