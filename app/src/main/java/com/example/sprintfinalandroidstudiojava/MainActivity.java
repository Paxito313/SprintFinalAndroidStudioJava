package com.example.sprintfinalandroidstudiojava;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.bmo);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        ImageButton imageButton1 = findViewById(R.id.yo);
        ImageButton imageButton2 = findViewById(R.id.wsp);
        ImageButton imageButton3 = findViewById(R.id.link);
        ImageButton imageButton4 = findViewById(R.id.gmail);

        Button buttonClose = findViewById(R.id.buttonClose);

        imageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("url", "https://www.instagram.com/paxo.mage/");
            startActivity(intent);
        });

        imageButton2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("url", "https://wa.me/56999248502");
            startActivity(intent);
        });

        imageButton3.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("url", "https://www.linkedin.com/in/sadmage-va-97459a232/");
            startActivity(intent);
        });

        imageButton4.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("url", "https://www.gmail.com");
            startActivity(intent);
        });

        buttonClose.setOnClickListener(v -> finishAffinity());
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.bmo);
            mediaPlayer.setLooping(true);
        }
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
