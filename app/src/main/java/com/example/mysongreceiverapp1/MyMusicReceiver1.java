package com.example.mysongreceiverapp1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

public class MyMusicReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        Log.d("MusicBroadcast", "Received  action " + intent.getAction());



        if (intent.getAction() == Intent.ACTION_BOOT_COMPLETED) {

            Log.d("MusicBroadcast", "Received  " + "boot completed");
            abortBroadcast();
            return;

        } else if (intent.getAction().equals("com.jasshugarg.imusic.currsong")) {
            String str = intent.getStringExtra("currPlayingSong");

            if(MainActivity.musicText!=null)
            MainActivity.musicText.setText(str);

            SharedPreferences sharedPreferences = context.getSharedPreferences("musicReceiver1", context.MODE_PRIVATE);
            SharedPreferences.Editor ed = sharedPreferences.edit();
            ed.putString("currPlayingSong", str);
            ed.apply();

            Log.d("MusicBroadcast", "Received  " + str);

            abortBroadcast();

            return;

        }


    }
}