package com.lrbresca.mobileapp.Network.Providers;

import com.lrbresca.mobileapp.Models.SearchDetailsProductResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchDetailsProductRestProvider {

    @GET("/items")
    Call<List<SearchDetailsProductResponse>> search(@Query("ids") String idProduct);

}
