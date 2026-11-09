package com.example.a341;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);

        new Thread(() -> {
            try {
                URL url = new URL("https://i.pinimg.com/736x/9a/0e/a5/9a0ea530cdcaf2ad17707da96838a041.jpg");
                InputStream inputStream = (InputStream) url.getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                runOnUiThread(() -> imageView.setImageBitmap(bitmap));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
