package com.lrbresca.mobileapp.Network.Services;

import android.os.AsyncTask;

import com.lrbresca.mobileapp.Callbacks.SearchDetailsProductCallback;
import com.lrbresca.mobileapp.Models.SearchDetailsProductResponse;
import com.lrbresca.mobileapp.Network.Providers.SearchDetailsProductRestProvider;
import com.lrbresca.mobileapp.Network.RetrofitApiClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SearchDetailsProductService extends AsyncTask {

    private String productId;
    private SearchDetailsProductCallback searchDetailsProductCallback;
    private Response<List<SearchDetailsProductResponse>> searchDetailsProductResponse;

    public SearchDetailsProductService(SearchDetailsProductCallback searchDetailsProductCallback, String productId){
        this.searchDetailsProductCallback = searchDetailsProductCallback;
        this.productId = productId;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            SearchDetailsProductRestProvider searchDetailsProductRestProvider = RetrofitApiClient.getClient().create(SearchDetailsProductRestProvider.class);
            Call<List<SearchDetailsProductResponse>> call = searchDetailsProductRestProvider.search(productId);
            searchDetailsProductResponse = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return searchDetailsProductResponse.body();
    }

    @Override
    protected void onPostExecute(Object o) {
        SearchDetailsProductResponse searchDetailsProduct = searchDetailsProductResponse.body().get(0);
        searchDetailsProductCallback.onSuccess(searchDetailsProduct);
    }
}
