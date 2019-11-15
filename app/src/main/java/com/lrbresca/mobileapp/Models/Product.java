package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Product {

    @SerializedName("id")
    private String idProduct;

    @SerializedName("site_id")
    private String siteId;

    private String title;

    private Seller seller;

    private String price;

    @SerializedName("currency_id")
    private String currencyId;

    @SerializedName("available_quantity")
    private float availableQuantity;

    @SerializedName("sold_quantity")
    private float soldQuantity;

    private String condition;

    private String thumbnail;

    @SerializedName("listing_type_id")
    private String listingTypeId;

    private ArrayList<Attributes> attributes = new ArrayList<>();

    @SerializedName("accepts_mercadopago")
    private boolean acceptsMercadopago;

    @SerializedName("category_id")
    private String categoryId;

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

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public float getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(float availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public float getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(float soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
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

    public boolean isAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    public ArrayList<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attributes> attributes) {
        this.attributes = attributes;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }
}
