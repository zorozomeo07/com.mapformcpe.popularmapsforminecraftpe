package com.mapformcpe.popularmapsforminecraftpe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PrivacyApp extends AppCompatActivity {
    ImageView img_poli1,img_poli2;
    TextView txt_poli1,txt_poli2,txt_poli3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_app);
        img_poli1=findViewById(R.id.img_poli1);
        img_poli2=findViewById(R.id.img_poli2);
        txt_poli1=findViewById(R.id.txt_poli1);
        txt_poli2=findViewById(R.id.txt_poli2);
        txt_poli3=findViewById(R.id.txt_poli3);
        // set
        txt_poli1.setText(R.string.poli1);
        txt_poli2.setText(R.string.poli2);
        txt_poli3.setText(R.string.poli3);
        //img
        img_poli1.setBackgroundResource(R.drawable.img10);
        img_poli2.setBackgroundResource(R.drawable.img5);


    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        startActivity(new Intent(PrivacyApp.this, bodySkin.class));

    }
}