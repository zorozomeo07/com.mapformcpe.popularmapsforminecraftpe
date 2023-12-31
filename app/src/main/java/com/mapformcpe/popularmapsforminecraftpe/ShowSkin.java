package com.mapformcpe.popularmapsforminecraftpe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowSkin extends AppCompatActivity {
    ImageView anh;
    int ms;
    String txt;
    TextView share,info,download,title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_skin);

        anh=findViewById(R.id.img_skin);
        share=findViewById(R.id.share_skin);
        info=findViewById(R.id.send);
        download=findViewById(R.id.download);
        title=findViewById(R.id.txt_skin_apps);
        txt=getIntent().getStringExtra("i_skin");
        ms=getIntent().getIntExtra("anh",R.drawable.img0);
        Log.d("open",txt + " nn  "+ms);
        anh.setBackgroundResource(ms);
        title.setText(txt);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://didongviet.vn/dchannel/game-minecraft/"));
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String linh_app="https://play.google.com/store/apps/details?id=com.mapformcpe.popularmapsforminecraftpe";
                Intent intent1=new Intent();
                intent1.setAction(Intent.ACTION_SEND);
                String text="Chào mừng bạn đến với ứng dụng của chúng tôi. Ứng dụng đem lại nhiều chường trình chơi game bổ ích cho người dùng.\n"+linh_app;
                intent1.putExtra(Intent.EXTRA_TEXT,text);
                intent1.setType("text/plain");
                startActivity(intent1);
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShowSkin.this,"Download ảnh thành công",Toast.LENGTH_LONG).show();
            }
        });


    }
    class DownloadImageTask extends AsyncTask<String, Void, Void> {
        private Context context;

        public DownloadImageTask(Context context) {
            this.context = context;
        }

        @Override
        protected Void doInBackground(String... params) {
            String imageUrl = params[0];

            try {
                // Mở kết nối đến URL
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();

                // Đọc dữ liệu từ URL
                InputStream input = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);

                // Lưu ảnh vào bộ nhớ
                saveImageToStorage(bitmap);

                // Đóng kết nối
                connection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
    private void saveImageToStorage(Bitmap bitmap) {
        try {
            String folderPath = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_PICTURES).getAbsolutePath();
            String fileName = "downloaded_image.jpg";

            File file = new File(folderPath, fileName);

            try (FileOutputStream fos = new FileOutputStream(file)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                Toast.makeText(ShowSkin.this,"Download ảnh thành công",Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(ShowSkin.this,"Download ảnh thất bại",Toast.LENGTH_LONG).show();
        }
    }

}