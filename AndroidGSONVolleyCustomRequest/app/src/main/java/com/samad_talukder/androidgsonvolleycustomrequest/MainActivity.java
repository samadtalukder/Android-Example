package com.samad_talukder.androidgsonvolleycustomrequest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.samad_talukder.androidgsonvolleycustomrequest.model.WeatherExample;
import com.samad_talukder.androidgsonvolleycustomrequest.volley.VolleyApiCAll;
import com.samad_talukder.androidgsonvolleycustomrequest.volley.VolleyCallback;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private String url = "http://api.openweathermap.org/data/2.5/weather?q=London&mode=json&appid=INSERT_KEY";
    private TextView tvWeatherType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWeatherType = findViewById(R.id.tvWeatherType);

        volleyGetRequestCAll();

        volleyPostRequestCAll();

    }

    private void volleyGetRequestCAll() {
        VolleyApiCAll.request_GET(this, url, new VolleyCallback() {
            @Override
            public void onSuccessResponse(String result) {
                parseGsonData(result);
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Error: ", volleyError.getMessage());
            }
        });

    }

    private void volleyPostRequestCAll() {
        JSONObject postParams = new JSONObject();
        try {

            postParams.put("city", "london");
            postParams.put("timestamp", "1571919407");


        } catch (JSONException json) {

        }
        VolleyApiCAll.request_POST(this, url, postParams, new VolleyCallback() {
            @Override
            public void onSuccessResponse(String result) {
                parseGsonData(result);
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("Error: ", volleyError.getMessage());
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void parseGsonData(String result) {
        WeatherExample weatherExample = new Gson().fromJson(result, WeatherExample.class);

        tvWeatherType.setText("Weather: "+weatherExample.getWeather().get(0).getMain());

        Log.e("Response: ", result);
        Log.e("Response: ", weatherExample.getWeather().get(0).getDescription());
    }
}
