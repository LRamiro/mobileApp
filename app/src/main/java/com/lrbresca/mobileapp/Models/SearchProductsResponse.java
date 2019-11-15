package com.lrbresca.mobileapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchProductsResponse {

    @SerializedName("site_id")
    private String siteId;
    private String query;
    @SerializedName("paging")
    private Paging pagingDetails;
    @SerializedName("results")
    private List<Product> products;
    private Sort sort;
    @SerializedName("available_sorts")
    private List<Sort> availableSorts;
    @SerializedName("filters")
    private List<MainFilter> filter;

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Paging getPagingDetails() {
        return pagingDetails;
    }

    public void setPagingDetails(Paging pagingDetails) {
        this.pagingDetails = pagingDetails;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setResults(List<Product> results) {
        this.products = results;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public List<Sort> getAvailableSorts() {
        return availableSorts;
    }

    public void setAvailableSorts(List<Sort> availableSorts) {
        this.availableSorts = availableSorts;
    }

    public List<MainFilter> getFilter() {
        return filter;
    }

    public void setFilter(List<MainFilter> filter) {
        this.filter = filter;
    }

}
