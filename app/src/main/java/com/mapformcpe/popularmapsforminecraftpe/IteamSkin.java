package com.mapformcpe.popularmapsforminecraftpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class IteamSkin extends AppCompatActivity {
    TextView txt_item_skin;
    String title;
    ArrayList<Skinmodel> lisst;
    AdpaterIteam iteam;
    RecyclerView recyIteam;
    DataSkin dataSkin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iteam_skin);
        recyIteam=findViewById(R.id.recy_item);
        // khai bao
        txt_item_skin=findViewById(R.id.txt_item_skin);
        title=getIntent().getStringExtra("iteam");
        txt_item_skin.setText(title);
        dataSkin=new DataSkin();
        switch (title){
            case "HelloNeihbor2": data1();
                break;
            case "Skyblock": data3();
                break;
            case "Vertoaky": data3();
                break;
            case "Tarader": data1();
                break;
            case "Neihbor": data3();
                break;
            case "mapgeo": data1();
                break;
            case "Vertinker": data3();
                break;
            case "TaraSkin": data2();
                break;
            case "heoninre": data2();
                break;
            case "cuinmap": data3();
                break;
            case "skinboyr": data2();
                break;
            case "aphaSkin": data3();
                break;
            default:
        }

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
       startActivity(new Intent(IteamSkin.this,SkinApp.class));
    }
    public void data1(){
        lisst=dataSkin.get1();
        Collections.shuffle(lisst);
        iteam=new AdpaterIteam(IteamSkin.this,R.layout.iteam_icon,lisst);
        recyIteam.setAdapter(iteam);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
        recyIteam.setLayoutManager(gridLayoutManager);
    }
    public void data2(){
        lisst=dataSkin.get2();
        Collections.shuffle(lisst);

        iteam=new AdpaterIteam(IteamSkin.this,R.layout.iteam_icon,lisst);
        recyIteam.setAdapter(iteam);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
        recyIteam.setLayoutManager(gridLayoutManager);
    }
    public void data3(){
        lisst=dataSkin.get3();
        Collections.shuffle(lisst);
        iteam=new AdpaterIteam(IteamSkin.this,R.layout.iteam_icon,lisst);
        recyIteam.setAdapter(iteam);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
        recyIteam.setLayoutManager(gridLayoutManager);
    }
}