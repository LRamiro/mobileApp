package com.lrbresca.mobileapp.Network.Providers;

import com.lrbresca.mobileapp.Models.SearchProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchProductsRestProvider {

    @GET("sites/MLA/search")
    Call<SearchProductsResponse> search(@Query("q") String idProduct);
}
