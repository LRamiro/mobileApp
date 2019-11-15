package com.lrbresca.mobileapp.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lrbresca.mobileapp.Contracts.DetailsProductContract;
import com.lrbresca.mobileapp.Models.Attributes;
import com.lrbresca.mobileapp.Models.Body;
import com.lrbresca.mobileapp.Models.Picture;
import com.lrbresca.mobileapp.Presenter.DetailsProductPresenter;
import com.lrbresca.mobileapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity implements DetailsProductContract.DetailsProductView {

    private String productId;
    private DetailsProductPresenter presenter;
    private TextView conditionProductTV, titleProductTV, attributesSubtitleTV, firstAttributeLabelTV,
            firstAttributeValueTV, secondAttributeLabelTV, secondAttributeValueTV, priceProductTV, currencyProductTV;
    private ImageView imageViewProductDetail;
    private ProgressBar productDetailsPB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        getIntentInfo();
        initUIComponents();
        presenter = new DetailsProductPresenter(this, productId);
        presenter.searchDetailsProduct();
    }

    private void getIntentInfo(){
            Intent intent = getIntent();
            productId = intent.getStringExtra("Product");
    }

    private void initUIComponents(){
        getSupportActionBar().setTitle(R.string.ProductDetailsActivity);
        productDetailsPB = findViewById(R.id.productDetailsPB);
        conditionProductTV = findViewById(R.id.conditionProductTV);
        titleProductTV = findViewById(R.id.titleProductTV);
        attributesSubtitleTV = findViewById(R.id.attributesSubtitleTV);
        firstAttributeLabelTV = findViewById(R.id.firstAttributeLabelTV);
        firstAttributeValueTV = findViewById(R.id.firstAttributeValueTV);
        secondAttributeLabelTV = findViewById(R.id.secondAttributeLabelTV);
        secondAttributeValueTV = findViewById(R.id.secondAttributeValueTV);
        priceProductTV = findViewById(R.id.priceProductTV);
        currencyProductTV = findViewById(R.id.currencyProductTV);
    }

    @Override
    public void showLoadingIndicator() {
        productDetailsPB.setVisibility(View.VISIBLE);
    }

    @Override
    public void completeMainProductDetails(Body responseBody) {
        hideLoadingIndicator();
        titleProductTV.setText(responseBody.getTitle());
        conditionProductTV.setText(responseBody.getCondition());
        attributesSubtitleTV.setText("Attributes");
        priceProductTV.setText(responseBody.getPrice());
        currencyProductTV.setText(responseBody.getCurrencyId());
    }

    @Override
    public void loadProductImage(Body responseBody){
        imageViewProductDetail = findViewById(R.id.photoProductIV);
        List<Picture> productPictures = responseBody.getPictures();
        Picture pictureChoosen = selectRandomPicture(productPictures);
        Picasso.get().load(pictureChoosen.getSecureUrl()).fit().into(imageViewProductDetail);
    }

    private Picture selectRandomPicture(List<Picture> pictures){
        int numbersToSelect = pictures.size();
        int numberChoosen = new Random().nextInt(numbersToSelect);

        return pictures.get(numberChoosen);
    }

    @Override
    public void loadAttributesProduct(List<Attributes> attributes) {
        String attribute1 = attributes.get(0).getName();
        String attribute2 = attributes.get(1).getName();
        String value1 = attributes.get(0).getValueName();
        String value2 = attributes.get(1).getValueName();

        firstAttributeLabelTV.setText(attribute1);
        secondAttributeLabelTV.setText(attribute2);
        firstAttributeValueTV.setText(value1);
        secondAttributeValueTV.setText(value2);
    }

    @Override
    public void showErrorMessage(String message) {
        hideLoadingIndicator();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void hideLoadingIndicator() {
        productDetailsPB.setVisibility(View.GONE);
    }
}
