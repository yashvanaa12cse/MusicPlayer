package com.example.musicplayer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlayingActivity extends AppCompatActivity {

    boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        String song = getIntent().getStringExtra("song");
        String artist = getIntent().getStringExtra("artist");

        TextView detailSong = findViewById(R.id.detailSong);
        TextView detailArtist = findViewById(R.id.detailArtist);
        ImageView detailImage = findViewById(R.id.detailImage);
        Button playButton = findViewById(R.id.playButton);
        Button backButton = findViewById(R.id.backButton);

        detailSong.setText(song);
        detailArtist.setText(artist);

        backButton.setOnClickListener(v -> finish());

        playButton.setOnClickListener(v -> {
            playing = !playing;

            if (playing) {
                playButton.setText("❚❚  Pause");
                Toast.makeText(this, "Playing " + song, Toast.LENGTH_SHORT).show();
            } else {
                playButton.setText("▶  Play");
                Toast.makeText(this, "Paused", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
