package samadtalukder.net.androidcustomtoastexample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    // Back Button Pressed
    boolean doubleBackToExitPressedOnce = false;
    //
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showToastMessage();
                showToastMessage2();
            }
        });

    }
    /*Another Method For Back button */
    /*
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        }
        if (this.mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
            super.onBackPressed();
        } else {
            View layout = getLayoutInflater().inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_layout_root));
            TextView text = (TextView) layout.findViewById(R.id.text);
            text.setText("Tap back button twice order to exit");
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(80, 0, 100);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
            this.mBackPressed = System.currentTimeMillis();
        }
    }
    */
    /**/
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        showToastMessageForExit();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    private void showToastMessageForExit() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        /*ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.ic_launcher_round);*/
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Tap back button twice order to exit");

        Toast toast = new Toast(getApplicationContext());
        /*toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);*/
        toast.setGravity(80, 0, 100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    private void showToastMessage2() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        ImageView image = (ImageView) layout.findViewById(R.id.image);
        image.setImageResource(R.mipmap.ic_launcher_round);
        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("Hello! This is a custom toast!");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    private void showToastMessage() {
        // Find custom toast example layout file
        View layoutValue = LayoutInflater.from(MainActivity.this).inflate(R.layout.toast, null);
        // Creating the Toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);

        // gravity, xOffset, yOffset
        toast.setGravity(Gravity.CENTER_VERTICAL, 5, 5);
        toast.setView(layoutValue);//setting the view of custom toast layout
        toast.show();
    }


}
