package com.lequtera.bms.webview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private FloatingActionButton fab;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.webViewSwipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
             loadURL();
            }
        });
        loadURL();

        fab = (FloatingActionButton)findViewById(R.id.floating_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BoothListActivity.class));
            }
        });
    }

    private void loadURL() {
        webView = (WebView)findViewById(R.id.webview);
        swipeRefreshLayout.setRefreshing(true);
        webView.setWebViewClient(new WebViewClient(){
            private String address = "https://electoralsearch.in/##resultArea";
//            @Override
//            public void onLoadResource(WebView view, String url) {
//                //                super.onLoadResource(view, url);
//                if(url.equals("https://electoralsearch.in/##resultArea")){
//                    Toast.makeText(MainActivity.this, "Result Page Opened", Toast.LENGTH_SHORT).show();
//                }
//            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                return super.shouldOverrideUrlLoading(view, url);
                if(url.equals(address)){
                    Toast.makeText(MainActivity.this, "Result Obtained", Toast.LENGTH_SHORT).show();
                    return  true;
                }
                else{
                    Toast.makeText(MainActivity.this, "Result Not Obtained", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

//            @Override
//            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
//                if(url.equals(address)){
//                    Toast.makeText(MainActivity.this, "Result Obtained", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this, "Result Not Obtained", Toast.LENGTH_SHORT).show();
//                }
//                return super.shouldInterceptRequest(view, url);
//
//            }
        });
        webView.loadUrl("https://electoralsearch.in/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }

    }
}
