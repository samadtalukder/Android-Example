package com.samad_talukder.androidgsonvolleycustomrequest.volley;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class VolleyApiCAll {
    private Context context;

    public VolleyApiCAll(Context context) {
        this.context = context;
    }

    public static void request_GET(Context context, String url, final VolleyCallback listener) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                listener.onSuccessResponse(String.valueOf(response));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                listener.onErrorResponse(error);

            }
        }) {

            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {

                    String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
                    return Response.success(new JSONObject(jsonString), HttpHeaderParser.parseCacheHeaders(response));

                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));

                } catch (JSONException je) {
                    return Response.error(new ParseError(je));
                }
            }
        };

        // Access the RequestQueue through singleton class.
        VolleySingleton.getInstance(context).addToRequestQueue(jsonObjectRequest);
    }

    public static void request_POST(Context context, String url, JSONObject jsonObject, final VolleyCallback listener) {

        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                listener.onSuccessResponse(String.valueOf(response));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                listener.onErrorResponse(error);

            }
        });

        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
