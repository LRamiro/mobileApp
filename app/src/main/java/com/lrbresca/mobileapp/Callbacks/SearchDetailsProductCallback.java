package com.lrbresca.mobileapp.Callbacks;

import com.lrbresca.mobileapp.Models.SearchDetailsProductResponse;

public interface SearchDetailsProductCallback {

    void onSuccess(SearchDetailsProductResponse searchDetailsProductResponse);

    void onFailure(Exception e);

}
