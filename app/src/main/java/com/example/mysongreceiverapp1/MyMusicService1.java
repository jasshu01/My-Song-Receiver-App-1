package com.example.mysongreceiverapp1;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.util.Log;

public class MyMusicService1 extends Service {
    public MyMusicService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String str = intent.getStringExtra("currPlayingSong");
        if (MainActivity.musicText != null)
            MainActivity.musicText.setText(str);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("musicReceiver1", getApplicationContext().MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString("currPlayingSong", str);
        ed.apply();

        Log.d("MusicBroadcast", "Received  " + str);


        return super.onStartCommand(intent, flags, startId);
    }
}