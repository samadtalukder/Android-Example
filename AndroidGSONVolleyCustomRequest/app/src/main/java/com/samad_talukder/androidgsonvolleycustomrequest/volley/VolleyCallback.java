package com.samad_talukder.androidgsonvolleycustomrequest.volley;

import com.android.volley.VolleyError;

public interface VolleyCallback {

    void onSuccessResponse(String result);

    void onErrorResponse(VolleyError volleyError);
}
