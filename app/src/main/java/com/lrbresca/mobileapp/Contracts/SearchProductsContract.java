package com.lrbresca.mobileapp.Contracts;

import com.lrbresca.mobileapp.Models.Product;

import java.util.List;

public interface SearchProductsContract {

    interface SearchProductsPresenter {
        void searchProducts();
    }

    interface View{
        void showLoadingIndicator();
        void hideLoadingIndicator();
        void setDataToRecyclerView(List<Product> searchResults);
        void showErrorMessage(String message);
    }

}
