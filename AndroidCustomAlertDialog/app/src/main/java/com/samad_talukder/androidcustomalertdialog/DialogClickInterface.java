package com.samad_talukder.androidcustomalertdialog;

import android.content.DialogInterface;

public interface DialogClickInterface {
    void onClickPositiveButton(DialogInterface pDialog, int pDialogIdentifier);

    void onClickNegativeButton(DialogInterface pDialog, int pDialogIdentifier);
}
