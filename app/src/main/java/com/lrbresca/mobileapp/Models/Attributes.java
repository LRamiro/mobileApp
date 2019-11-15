package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

public class Attributes {

    private String id;
    @SerializedName("value_id")
    private String valueId;
    private String name;
    @SerializedName("value_name")
    private String valueName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

}
