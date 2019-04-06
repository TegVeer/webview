package com.lequtera.bms.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView)findViewById(R.id.webview);
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
