package com.samad_talukder.pickimagefromgalleryorcamerainandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button pickImageBtn;
    private ImageView showPickImage;
    private static final String SAVE_IMAGE_DIRECTORY = "/PickImage";
    private int GALLERY = 1, CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestMultiplePermissions();

        pickImageBtn = findViewById(R.id.btn);
        showPickImage = findViewById(R.id.iv);

        pickImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPickImageChoseDialog();
            }
        });

    }

    private void showPickImageChoseDialog() {

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

        alertBuilder.setTitle("Select Action");

        String[] pictureDialogItems = {"Select photo from gallery", "Capture photo from camera"};

        alertBuilder.setItems(pictureDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                switch (i) {

                    case 0:

                        choosePhotoFromGallery();

                        break;

                    case 1:

                        choosePhotoFromCamera();

                        break;
                }
            }
        });

        alertBuilder.show();
    }

    private void choosePhotoFromCamera() {

        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        startActivityForResult(intentCamera, CAMERA);
    }

    private void choosePhotoFromGallery() {

        Intent intentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intentGallery, GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_CANCELED) {
            return;
        }

        if (requestCode == GALLERY && resultCode == RESULT_OK) {

            if (data != null && data.getExtras() != null) {

                Uri uri = data.getData();

                try {

                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                    saveImage(bitmap);

                    Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show();

                    showPickImage.setVisibility(View.VISIBLE);

                    showPickImage.setImageBitmap(bitmap);


                } catch (FileNotFoundException e) {

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();

                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();

                }
            }
        } else if (requestCode == CAMERA && resultCode == RESULT_OK) {

            if (data != null && data.getExtras() != null) {
                Bitmap cameraBitmap = (Bitmap) data.getExtras().get("data");

                showPickImage.setImageBitmap(cameraBitmap);

                showPickImage.setVisibility(View.VISIBLE);

                saveImage(cameraBitmap);

                Toast.makeText(this, "Image Saved", Toast.LENGTH_SHORT).show();
            }

        }
    }

    private String saveImage(Bitmap bitmap) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);

        File saveImageDir = new File(Environment.getExternalStorageDirectory() + SAVE_IMAGE_DIRECTORY);

        if (!saveImageDir.exists()) {
            saveImageDir.mkdirs();
        }

        try {

            @SuppressLint("SimpleDateFormat")
            String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(new Date());

            File imgFile = new File(saveImageDir, "IMG_" + timeStamp + ".jpg");

            imgFile.createNewFile();

            FileOutputStream fileOutputStream = new FileOutputStream(imgFile);

            fileOutputStream.write(byteArrayOutputStream.toByteArray());

            MediaScannerConnection.scanFile(this, new String[]{imgFile.getPath()}, new String[]{"image/jpeg"}, null);

            fileOutputStream.close();

            Log.e("TAG", "File Saved::--->" + imgFile.getAbsolutePath());
            Log.e("TAG", "File Size::--->" + imgFile.length());

            return imgFile.getAbsolutePath();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    private void requestMultiplePermissions() {

        Dexter.withActivity(this)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {

                        if (report.areAllPermissionsGranted()) {
                            Toast.makeText(getApplicationContext(), "All permissions are granted by user!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).
                withErrorListener(new PermissionRequestErrorListener() {
                    @Override
                    public void onError(DexterError error) {
                        Toast.makeText(getApplicationContext(), "Some Error! ", Toast.LENGTH_SHORT).show();
                    }
                })
                .onSameThread()
                .check();
    }

}
