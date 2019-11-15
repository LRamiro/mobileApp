package com.lrbresca.mobileapp.Presenter;

import com.lrbresca.mobileapp.Callbacks.SearchDetailsProductCallback;
import com.lrbresca.mobileapp.Contracts.DetailsProductContract;
import com.lrbresca.mobileapp.Models.SearchDetailsProductResponse;
import com.lrbresca.mobileapp.Network.Services.SearchDetailsProductService;

public class DetailsProductPresenter  implements DetailsProductContract.DetailsProductPresenter, SearchDetailsProductCallback {

    private DetailsProductContract.DetailsProductView detailsProductView;
    private SearchDetailsProductService searchDetailsProductService;

    public DetailsProductPresenter(DetailsProductContract.DetailsProductView view, String idProduct){
        this.detailsProductView = view;
        this.searchDetailsProductService = new SearchDetailsProductService(this, idProduct);
    }

    @Override
    public void searchDetailsProduct() {
        detailsProductView.showLoadingIndicator();
        searchDetailsProductService.execute();

    }

    @Override
    public void onSuccess(SearchDetailsProductResponse searchDetailsProductResponse) {
        boolean productIDExists = productIdExist(searchDetailsProductResponse.getCode());
        if(productIDExists){
            //detailsProductView.hideLoadingIndicator();
            detailsProductView.completeMainProductDetails(searchDetailsProductResponse.getBody());
            detailsProductView.loadProductImage(searchDetailsProductResponse.getBody());
            detailsProductView.loadAttributesProduct(searchDetailsProductResponse.getBody().getAttributes());
        }


    }

    @Override
    public void onFailure(Exception e) {
        detailsProductView.showErrorMessage(e.getMessage());
    }

    private boolean productIdExist(String searchResultCode){
        if(searchResultCode.equalsIgnoreCase("200")){
            return true;
        }
        return false;
    }
}
