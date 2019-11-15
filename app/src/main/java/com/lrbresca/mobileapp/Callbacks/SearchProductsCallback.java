package com.lrbresca.mobileapp.Callbacks;

import com.lrbresca.mobileapp.Models.Product;

import java.util.List;

public interface SearchProductsCallback {

    void onSuccess(List<Product> products);

    void onFailure(Exception e);

}
