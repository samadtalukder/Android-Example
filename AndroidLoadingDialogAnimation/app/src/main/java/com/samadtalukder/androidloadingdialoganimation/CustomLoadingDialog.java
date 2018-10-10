package com.samadtalukder.androidloadingdialoganimation;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;

public class CustomLoadingDialog {
    private Activity activity;
    private Dialog dialog;


    public CustomLoadingDialog(Activity activity) {
        this.activity = activity;
    }
    public void showDialog(){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_loading);
        ImageView loadingGif = dialog.findViewById(R.id.loadingGIF1);

        Glide.with(activity)
                .load(R.drawable.loading_2)
                .apply(new RequestOptions().placeholder(R.drawable.loading_1).centerCrop())
                .into(new DrawableImageViewTarget(loadingGif));

        dialog.show();
    }

    public void hideDialog(){
        dialog.dismiss();
    }

}
