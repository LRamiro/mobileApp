package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Path {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("path_from_root")
    private List<Path> pathFromRoot;

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

    public List<Path> getPathFromRoot() {
        return pathFromRoot;
    }

    public void setPathFromRoot(List<Path> pathFromRoot) {
        this.pathFromRoot = pathFromRoot;
    }
}
