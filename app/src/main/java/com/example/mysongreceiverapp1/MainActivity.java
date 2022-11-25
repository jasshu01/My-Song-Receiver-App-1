package com.example.mysongreceiverapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static TextView musicText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        musicText = findViewById(R.id.music);


        SharedPreferences sharedPreferences = getSharedPreferences("musicReceiver1", MODE_PRIVATE);
        musicText.setText(
                sharedPreferences.getString("currPlayingSong", "Didn't Received any message yet"));

    }
}