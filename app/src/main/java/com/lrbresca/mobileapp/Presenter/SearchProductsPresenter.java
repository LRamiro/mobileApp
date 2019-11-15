package com.lrbresca.mobileapp.Presenter;

import com.lrbresca.mobileapp.Callbacks.SearchProductsCallback;
import com.lrbresca.mobileapp.Contracts.SearchProductsContract;
import com.lrbresca.mobileapp.Models.Product;
import com.lrbresca.mobileapp.Network.Services.SearchProductsService;

import java.util.List;

public class SearchProductsPresenter implements SearchProductsContract.SearchProductsPresenter, SearchProductsCallback {

    private SearchProductsContract.View searchProductView;
    private SearchProductsService searchProductsService;

    public SearchProductsPresenter(SearchProductsContract.View searchProductView, String paramToSearch){
        this.searchProductView = searchProductView;
        this.searchProductsService = new SearchProductsService(this, paramToSearch);
    }

    @Override
    public void searchProducts() {
        searchProductView.showLoadingIndicator();
        searchProductsService.execute();
    }

    @Override
    public void onSuccess(List<Product> searchResult) {
        searchProductView.setDataToRecyclerView(searchResult);
    }

    @Override
    public void onFailure(Exception e) {
        searchProductView.showErrorMessage(e.getMessage());

    }
}