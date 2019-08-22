package com.samad_talukder.androidswiperefreshlayoutexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeRefreshLayout = null;
    private WebView webView;
    private WebViewClient webViewClient;
    private String TAG = "WebView";
    private String WEB_URL = "https://code.tutsplus.com/categories/android";
    private ListView listView;
    private List<String> dataList = null;
    private ArrayAdapter<String> listDataAdapter = null;
    // This handler is used to update activity UI components
    private Handler uiHandler = null;
    // This message means update list view
    private int MESSAGE_UPDATE_LIST_VIEW = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshUsingListView();

        // swipeRefreshUsingWebView();

    }

    @SuppressLint("HandlerLeak")
    private void swipeRefreshUsingListView() {
        if (listView == null) {

            listView = findViewById(R.id.swipe_refresh_layout_list_view);

            dataList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                dataList.add("List Item " + (i + 1));

            }

            listDataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataList);

            listView.setAdapter(listDataAdapter);
        }

        if (swipeRefreshLayout == null) {

            swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

            swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorCyan);

            int[] swipeIndicatorColorArr = {R.color.colorRed, R.color.colorGreen, R.color.colorOrange};

            swipeRefreshLayout.setColorSchemeResources(swipeIndicatorColorArr);

            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    refreshListView();
                }
            });
        }

        if (uiHandler == null) {

            uiHandler = new Handler() {
                @Override
                public void handleMessage(@NonNull Message msg) {

                    // If the message want to refresh list view.
                    if (msg.what == MESSAGE_UPDATE_LIST_VIEW) {

                        // Refresh list view after add item data.
                        listDataAdapter.notifyDataSetChanged();
                    }

                    // Stop showing the swipe refresh layout.
                    swipeRefreshLayout.setRefreshing(false);
                }
            };
        }
    }

    private void refreshListView() {
        new Thread(new Runnable() {
            @Override
            public void run() {

                //Thread.sleep(3000);

                int size = dataList.size();

                Log.e(TAG, "Size: " + size);

                for (int i = size; i < (size + 10); i++) {

                    dataList.add(i - size, "List Item " + (i + 1));

                    Log.e(TAG, "List Item: " + (i + 1));
                }

                Message message = new Message();

                message.what = MESSAGE_UPDATE_LIST_VIEW;

                uiHandler.sendMessage(message);

            }
        }).start();
    }

    private void swipeRefreshUsingWebView() {

        //webView = findViewById(R.id.webView);

        webView.loadUrl(WEB_URL);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.d(TAG, "onRefresh called");

                // webView.reload();
            }
        });

        webViewClient = new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "onPageFinished called");

                swipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onPageCommitVisible(WebView view, String url) {
                super.onPageCommitVisible(view, url);
                Log.d(TAG, "onPageCommitVisible called");

                swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);

                Log.d(TAG, "onLoadResource called");

                swipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
            }
        };

        webView.setWebViewClient(webViewClient);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                webView.loadUrl("http://www.google.com");
                Log.d(TAG, "Load After 2 seconds");
            }
        }, 2000);
    }

}
