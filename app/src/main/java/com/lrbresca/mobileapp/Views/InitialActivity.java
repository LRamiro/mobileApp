package com.lrbresca.mobileapp.Views;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lrbresca.mobileapp.R;
import com.lrbresca.mobileapp.Utils.AlertDialogBuilder;

public class InitialActivity extends AppCompatActivity implements DialogInterface.OnClickListener{

    private EditText searchET;
    private Button searchButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initUIComponents();
    }

    private void initUIComponents() {
        getSupportActionBar().setTitle(R.string.SearchProductsActivity);
        searchET = findViewById(R.id.searchET);
        searchButton = findViewById(R.id.searchButtonB);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchET.getText().length() > 0) {
                    Intent intent = new Intent(getApplicationContext(), SearchProductsActivity.class);
                    intent.putExtra("Key", searchET.getText().toString());
                    startActivity(intent);
                } else {
                    informToUserNoDataWasEntered();
                }
            }
        });
    }

    private void informToUserNoDataWasEntered(){
        AlertDialogBuilder alertDialogBuilder = new AlertDialogBuilder(this, this);
        alertDialogBuilder.showAlertDialog(R.string.InitialActivityTittle, R.string.InitialActivityMessage);

    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
