package com.lrbresca.mobileapp.Utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class AlertDialogBuilder {

    private Context context;
    private DialogInterface.OnClickListener onClickListener;

    public AlertDialogBuilder(Context context, DialogInterface.OnClickListener onClickListener){
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public void showAlertDialog(int title, int subtitle) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(subtitle)
                .setPositiveButton("OK", onClickListener)
                .show();
    }
}
