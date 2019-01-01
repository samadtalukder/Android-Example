package com.samad.talukder.androidalertdialogexample;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogUtils {
    private Activity activity;

    public DialogUtils(Activity activity) {
        this.activity = activity;
    }

    private Dialog buildDialogView(int layout) {
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(layout);
        dialog.setCancelable(false);
        WindowManager.LayoutParams winLayoutParams = new WindowManager.LayoutParams();
        winLayoutParams.copyFrom(dialog.getWindow().getAttributes());
        winLayoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
        winLayoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.getWindow().setAttributes(winLayoutParams);
        return dialog;
    }

    public Dialog dialogInfo(String title, String description, String positiveBtnText, int icon, final CallBackDialog callBackDialog) {
        final Dialog dialog = buildDialogView(R.layout.custom_alert_layout);
        ((TextView) dialog.findViewById(R.id.title)).setText(title);
        ((TextView) dialog.findViewById(R.id.content)).setText(description);
        ((Button) dialog.findViewById(R.id.bt_positive)).setText(positiveBtnText);
        ((ImageView) dialog.findViewById(R.id.icon)).setImageResource(icon);
        ((Button) dialog.findViewById(R.id.bt_positive)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBackDialog.onPositiveAction(dialog);
            }
        });


        return dialog;
    }
}
