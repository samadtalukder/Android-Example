package com.samad_talukder.androidcustomalertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class CustomAlertDialog implements DialogClickInterface, DialogInterface.OnClickListener {
    public static CustomAlertDialog mDialog;
    public DialogClickInterface mDialogClickInterface;
    private int mDialogIdentifier;
    private Context mContext;

    public static CustomAlertDialog getInstance() {
        if (mDialog == null)
            mDialog = new CustomAlertDialog();

        return mDialog;

    }

    public void showConfirmDialog(String pTitle, String pMessage,
                                  String pPositiveButton, String pNegativeButton,
                                  Context pContext, final int pDialogIdentifier) {

        mDialogClickInterface = (DialogClickInterface) pContext;
        mDialogIdentifier = pDialogIdentifier;
        mContext = pContext;

        final Dialog dialog = new Dialog(pContext);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_confirm_dialog);

        if (!pTitle.equals("")) {
            TextView title = dialog.findViewById(R.id.textTitle);
            title.setText(pTitle);
            title.setVisibility(View.VISIBLE);
        }

        TextView text = dialog.findViewById(R.id.textDialog);
        text.setText(pMessage);
        Button positiveButton = dialog.findViewById(R.id.positiveButton);
        positiveButton.setText(pPositiveButton);
        Button negativeButton = dialog.findViewById(R.id.negativeButton);
        negativeButton.setText(pNegativeButton);
        dialog.setCancelable(true);
        dialog.show();
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                mDialogClickInterface.onClickPositiveButton(dialog, pDialogIdentifier);
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                mDialogClickInterface.onClickNegativeButton(dialog, pDialogIdentifier);
            }
        });

    }

    @Override
    public void onClick(DialogInterface pDialog, int pWhich) {

        switch (pWhich) {
            case DialogInterface.BUTTON_POSITIVE:
                mDialogClickInterface.onClickPositiveButton(pDialog, mDialogIdentifier);

                break;
            case DialogInterface.BUTTON_NEGATIVE:
                mDialogClickInterface.onClickNegativeButton(pDialog, mDialogIdentifier);
                break;
        }

    }

    @Override
    public void onClickPositiveButton(DialogInterface pDialog, int pDialogIntefier) {
    }

    @Override
    public void onClickNegativeButton(DialogInterface pDialog, int pDialogIntefier) {
    }

}
