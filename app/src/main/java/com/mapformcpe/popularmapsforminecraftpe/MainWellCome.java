package com.mapformcpe.popularmapsforminecraftpe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;

public class MainWellCome extends AppCompatActivity {
    TelephonyManager tm;
    String mavung,tmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_well_come);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tm = (TelephonyManager)this.getSystemService(Context.TELEPHONY_SERVICE);
        mavung = tm.getNetworkCountryIso();
        new Thread(new Runnable() {
            public void run() {
                boolean check = isConnectedToServer("https://gamebanca.shop/imgdemo/img3112.png");
                MainWellCome.this.runOnUiThread(new Runnable() {
                    public void run() {
                        Log.e("isConnected", check + " ");
                        if ((mavung.equals("vn") || mavung.equals("VN")) && !isRunningOnEmulator() && check==true ) {
                            Intent intent = new Intent(MainWellCome.this, AppModeSkin.class);
                            intent.putExtra("check", ""+check);
                            startActivity(intent);
                        } else {
                            startActivity(new Intent(MainWellCome.this, bodySkin.class));
                        }

                    }
                });
            }
        }).start();

    }
    public boolean isConnectedToServer(String url) {
        try{
            URL urls = new URL(url);
            HttpURLConnection connection = (HttpURLConnection)urls.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int code = connection.getResponseCode();
            if (code == 200){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
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

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}