package com.samad.talukder.androidalertdialogexample;

import android.app.Dialog;
import android.view.View;

public interface CallBackDialog extends View.OnClickListener {
    void onPositiveAction(Dialog dialog);

    void onNegativeAction(Dialog dialog);

    void onNeutralAction(Dialog dialog);
}
