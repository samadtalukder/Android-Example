package com.samadtalukder.androidqiblacompassexample;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.content.pm.PackageManager.FEATURE_SENSOR_COMPASS;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView compassAngle;
    private ImageView compassImage;
    // record the compass picture angle turned
    private float mCurrentDegree = 0f;
    // device sensor manager
    private SensorManager sensorManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compassImage = findViewById(R.id.compassImage);
        compassAngle = findViewById(R.id.showAngleTV);
        // initialize your android device sensor capabilities
        sensorManager = (SensorManager) getApplicationContext().getSystemService(SENSOR_SERVICE);
        PackageManager packageManager = getPackageManager();
        /*Check your device is supported for compass*/
        boolean check = packageManager.hasSystemFeature(FEATURE_SENSOR_COMPASS);
        if (!check) {
            Toast.makeText(this, "Not Support", Toast.LENGTH_SHORT).show();
        }
    }

    public void onResume() {
        super.onResume();
        // for the system's orientation sensor registered listeners
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION), SensorManager.SENSOR_DELAY_GAME);
    }

    public void onPause() {
        super.onPause();
        // to stop the listener and save battery
        sensorManager.unregisterListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        // create a rotation animation (reverse turn degree degrees)
        float degree = Math.round(sensorEvent.values[0]);
        compassAngle.setText("Angel: "+degree + " Degree");
        RotateAnimation compass_ra = new RotateAnimation(mCurrentDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        // how long the animation will take place
        compass_ra.setDuration(210);
        // set the animation after the end of the reservation status
        compass_ra.setFillAfter(true);
        // Start the animation
        compassImage.startAnimation(compass_ra);
        mCurrentDegree = -degree;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        PackageManager packageManager = getPackageManager();
        boolean check = packageManager.hasSystemFeature(FEATURE_SENSOR_COMPASS);
        if (!check) {
            Toast.makeText(this, "Not Support", Toast.LENGTH_SHORT).show();
        }
    }
}
