package com.mapformcpe.popularmapsforminecraftpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SkinApp extends AppCompatActivity {
    RecyclerView recySkinIcon;
    EditText txt_input;
    ImageView img_search;
    ArrayList<Skinmodel> skinall;
    String txt;

    AdpaterSkin adpaterSkin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skin_app);
         skinall=new ArrayList<>();
        skinall.add(new Skinmodel("HelloNeihbor2",R.drawable.img0));
        skinall.add(new Skinmodel("Skyblock",R.drawable.img4));
        skinall.add(new Skinmodel("Vertoaky",R.drawable.img3));
        skinall.add(new Skinmodel("Tarader",R.drawable.img9));
        skinall.add(new Skinmodel("Neihbor",R.drawable.img2));
        skinall.add(new Skinmodel("mapgeo",R.drawable.img7));
        skinall.add(new Skinmodel("Vertinker",R.drawable.img15));
        skinall.add(new Skinmodel("TaraSkin",R.drawable.img16));
        skinall.add(new Skinmodel("heoninre",R.drawable.img24));
        skinall.add(new Skinmodel("cuinmap",R.drawable.img11));
        skinall.add(new Skinmodel("skinboyr",R.drawable.img21));
        skinall.add(new Skinmodel("aphaSkin",R.drawable.img25));

        // mimap
        recySkinIcon=findViewById(R.id.recy_item);
        txt_input=findViewById(R.id.txt_search);
        img_search=findViewById(R.id.img_search);
        // list
        adpaterSkin=new AdpaterSkin(SkinApp.this,R.layout.iteam_icon, skinall);
        recySkinIcon.setAdapter(adpaterSkin);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
        recySkinIcon.setLayoutManager(gridLayoutManager);


        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt=txt_input.getText().toString();
                if (txt.length()==0) {
                    Toast.makeText(SkinApp.this,"Vui lòng nhập tên cần tìm, không để trống",Toast.LENGTH_LONG).show();
                }else {
                    DataSkin dataSkin=new DataSkin();
                    ArrayList<Skinmodel> a=new ArrayList<>();
                    a=dataSkin.getAll();
                    Collections.shuffle(a);
                    adpaterSkin=new AdpaterSkin(SkinApp.this,R.layout.iteam_icon, a);
                    recySkinIcon.setAdapter(adpaterSkin);
                    GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),3,RecyclerView.VERTICAL,false);
                    recySkinIcon.setLayoutManager(gridLayoutManager);
                }
            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        startActivity(new Intent(SkinApp.this, bodySkin.class));
    }

    public void showCertainPlayerInformation(ArrayList<Skinmodel> playerList, String inputName)
    {

        for (Skinmodel player : playerList)
        {
            String userCheck = player.getType();
            if (userCheck.equals(inputName))
            {
                ArrayList<Skinmodel> a=new ArrayList<>();
                a.add(player);
                adpaterSkin=new AdpaterSkin(SkinApp.this,R.layout.iteam_icon, skinall);
                recySkinIcon.setAdapter(adpaterSkin);
                GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3,RecyclerView.VERTICAL,false);
                recySkinIcon.setLayoutManager(gridLayoutManager);
                Log.d("openApp","1");
            }
            return;

        }

        Toast.makeText(getApplicationContext(), "Không tìm thấy dữ liệu", Toast.LENGTH_SHORT).show();
    }

}