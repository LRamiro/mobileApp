package com.lrbresca.mobileapp.Network.Services;

import android.os.AsyncTask;

import com.lrbresca.mobileapp.Callbacks.SearchProductsCallback;
import com.lrbresca.mobileapp.Models.Product;
import com.lrbresca.mobileapp.Models.SearchProductsResponse;
import com.lrbresca.mobileapp.Network.Providers.SearchProductsRestProvider;
import com.lrbresca.mobileapp.Network.RetrofitApiClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class SearchProductsService extends AsyncTask {

    private SearchProductsCallback searchProductsCallback;
    private String paramToSearch;
    private Response<SearchProductsResponse> searchProductsResponse;
    private List<Product> products;

    public SearchProductsService(SearchProductsCallback searchProductsCallback, String paramToSearch){
        this.searchProductsCallback = searchProductsCallback;
        this.paramToSearch = paramToSearch;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            SearchProductsRestProvider searchProductsRestProvider = RetrofitApiClient.getClient().create(SearchProductsRestProvider.class);
            Call<SearchProductsResponse> call = searchProductsRestProvider.search(paramToSearch);
            searchProductsResponse = call.execute();
            products = searchProductsResponse.body().getProducts();

        } catch (IOException e) {
            e.printStackTrace();
            products = null;
        }
        return products;
    }

    @Override
    protected void onPostExecute(Object o) {
        if(products != null){
            searchProductsCallback.onSuccess(products);
        }else{
            searchProductsCallback.onFailure(new Exception("There was an error during the transaction"));
        }
    }
}
