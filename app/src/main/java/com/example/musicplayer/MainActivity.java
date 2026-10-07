package com.example.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[][] songs = {
            {"Midnight Drive", "Luna Waves"},
            {"Golden Hour", "The Skylines"},
            {"Ocean Eyes", "Mira"},
            {"Afterglow", "Nova Lane"},
            {"City Lights", "Echo Avenue"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout songList = findViewById(R.id.songList);
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < songs.length; i++) {
            View item = inflater.inflate(R.layout.item_song, songList, false);

            TextView songName = item.findViewById(R.id.songName);
            TextView artistName = item.findViewById(R.id.artistName);

            songName.setText(songs[i][0]);
            artistName.setText(songs[i][1]);

            final int position = i;
            item.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                intent.putExtra("song", songs[position][0]);
                intent.putExtra("artist", songs[position][1]);
                startActivity(intent);
            });

            songList.addView(item);
        }
    }
}
