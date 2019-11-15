package com.lrbresca.mobileapp.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.lrbresca.mobileapp.Contracts.SearchProductsContract;
import com.lrbresca.mobileapp.Models.Product;
import com.lrbresca.mobileapp.Presenter.SearchProductsPresenter;
import com.lrbresca.mobileapp.R;
import com.lrbresca.mobileapp.Adapters.SearchResultsAdapter;
import com.lrbresca.mobileapp.Utils.AlertDialogBuilder;

import java.util.ArrayList;
import java.util.List;

public class SearchProductsActivity extends AppCompatActivity implements SearchProductsContract.View, SearchResultsAdapter.OnItemClickListener, DialogInterface.OnClickListener{

    private String searchParam;
    private SearchProductsPresenter presenter;

    private List<Product> searchResults;

    private ProgressBar searchProductsPB;
    private RecyclerView searchProductsRV;
    private RecyclerView.Adapter searchProductsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        getIntentInfo();
        initUIComponents();
        presenter = new SearchProductsPresenter(this, searchParam);
        presenter.searchProducts();
    }

    private void getIntentInfo(){
        Intent intent = getIntent();
        searchParam = intent.getStringExtra("Key");
    }

    private void initUIComponents(){
        getSupportActionBar().setTitle(R.string.ResultSearchActivity);
        searchProductsRV = findViewById(R.id.listRV);
        searchProductsPB = findViewById(R.id.searchProductsPB);
        layoutManager = new LinearLayoutManager(this);
        searchProductsRV.setLayoutManager(layoutManager);
        searchResults = new ArrayList<>();
        searchProductsAdapter = new SearchResultsAdapter(searchResults, this);
        searchProductsRV.setAdapter(searchProductsAdapter);
    }

    @Override
    public void onItemClick(Product item) {
        if (item!=null){
            navigateToProductDetailPage(item.getIdProduct());
        }
    }

    @Override
    public void showLoadingIndicator() {
        searchProductsPB.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingIndicator() {
        searchProductsPB.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerView(List<Product> searchResults) {
        hideLoadingIndicator();
        if(searchResults.size()>0) {
            this.searchResults.addAll(searchResults);
            searchProductsAdapter.notifyDataSetChanged();
        } else {
            informToUserThereIsntResults();
        }
    }

    private void informToUserThereIsntResults(){
        AlertDialogBuilder alertDialogBuilder = new AlertDialogBuilder(this, this);
        alertDialogBuilder.showAlertDialog(R.string.SearchProductsActivityTitle, R.string.SearchProductsActivityMessage);
    }

    private void navigateToProductDetailPage(String idProduct){
        Intent detailIntent = new Intent(getApplicationContext(), DetailsActivity.class);
        detailIntent.putExtra("Product", idProduct);
        startActivity(detailIntent);
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Intent initialActivityIntent = new Intent(SearchProductsActivity.this, InitialActivity.class);
        startActivity(initialActivityIntent);
    }

    @Override
    public void showErrorMessage(String message) {
        hideLoadingIndicator();
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}