package com.example.cln_tesla;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cln_tesla.databinding.ActivityWebsiteBinding;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class website<mywebview> extends AppCompatActivity {
   private WebView mywebview;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_website );
        mywebview = (WebView) findViewById( R.id.webview );
        mywebview.setWebViewClient( new WebViewClient());
        mywebview.loadUrl( "https://www.tesla.com/" );
        mywebview.setScrollBarStyle( View.SCROLLBARS_INSIDE_OVERLAY );
        WebSettings webSettings=mywebview.getSettings();
        webSettings.setRenderPriority( WebSettings.RenderPriority.HIGH );
        webSettings.setCacheMode( webSettings.LOAD_CACHE_ELSE_NETWORK );
        webSettings.setAppCacheEnabled( true );
        webSettings.setDomStorageEnabled( true );
        webSettings.setLayoutAlgorithm( WebSettings.LayoutAlgorithm.NARROW_COLUMNS  );
        webSettings.setUseWideViewPort( true );
        webSettings.setEnableSmoothTransition( true );


        webSettings.setJavaScriptEnabled( true );

    }

    @Override
    public void onBackPressed() {
        if(mywebview.canGoBack()){
            mywebview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}