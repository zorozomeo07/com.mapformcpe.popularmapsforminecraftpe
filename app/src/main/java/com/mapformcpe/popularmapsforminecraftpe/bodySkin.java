package com.mapformcpe.popularmapsforminecraftpe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class bodySkin extends AppCompatActivity {
    LinearLayout lin_app, lin_share,lin_rate,lin_policy,lin_more;
    String link_more="https://play.google.com/store/apps/developer?id=GoddessDev";
    String link_app="https://play.google.com/store/apps/details?id=com.mapformcpe.popularmapsforminecraftpe";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_skin);
        lin_app=findViewById(R.id.skinGame);
        lin_share=findViewById(R.id.share);
        lin_rate=findViewById(R.id.rate);
        lin_policy=findViewById(R.id.policy);
        lin_more=findViewById(R.id.more);
        lin_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(bodySkin.this,SkinApp.class);
                startActivity(intent);
            }
        });
        lin_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareAPP(link_app);
            }
        });
        lin_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent app=new Intent(bodySkin.this,PrivacyApp.class);
                startActivity(app);
            }
        });
        lin_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateweb(link_app);
            }
        });
        lin_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateweb(link_more);
            }
        });

    }
    // chuyển link sang chomre
    public void updateweb(String link){
        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(intent);
    }
    // share
    public void ShareAPP(String links){
        Intent intent1=new Intent();
        intent1.setAction(Intent.ACTION_SEND);
        String text="Chào mừng bạn đến với ứng dụng của chúng tôi. Ứng dụng đem lại nhiều chường trình chơi game bổ ích cho người dùng.\n"+links;
        intent1.putExtra(Intent.EXTRA_TEXT,text);
        intent1.setType("text/plain");
        startActivity(intent1);

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}