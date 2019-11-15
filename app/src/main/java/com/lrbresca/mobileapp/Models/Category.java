package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("name")
    private String categorieName;

    @SerializedName("id")
    private String categoryCode;

    public String getCategorieName() {
        return categorieName;
    }

    public void setCategorieName(String categorieName) {
        this.categorieName = categorieName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}
