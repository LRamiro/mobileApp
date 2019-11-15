package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainFilter {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("values")
    private List<Path> values;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Path> getValues() {
        return values;
    }

    public void setValues(List<Path> values) {
        this.values = values;
    }
}
