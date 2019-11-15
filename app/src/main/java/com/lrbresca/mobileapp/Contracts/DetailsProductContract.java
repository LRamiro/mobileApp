package com.lrbresca.mobileapp.Contracts;

import com.lrbresca.mobileapp.Models.Attributes;
import com.lrbresca.mobileapp.Models.Body;

import java.util.List;

public interface DetailsProductContract {

    interface DetailsProductPresenter {
        void searchDetailsProduct();
    }

    interface DetailsProductView {
        void showLoadingIndicator();
        void completeMainProductDetails(Body responseBody);
        void loadProductImage(Body responseBody);
        void loadAttributesProduct(List<Attributes> attributes);
        void showErrorMessage(String message);
        void hideLoadingIndicator();
    }
}
