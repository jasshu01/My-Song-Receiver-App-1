package com.example.mysongreceiverapp1;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.TextView;

public class MyMusicReceiver1 extends BroadcastReceiver {

    @SuppressLint("SuspiciousIndentation")
    @Override
    public void onReceive(Context context, Intent intent) {

//        Log.d("MusicBroadcast", "Received  action " + intent.getAction());



        if (intent.getAction() == Intent.ACTION_BOOT_COMPLETED) {

            Log.d("MusicBroadcast", "Received  " + "boot completed");
            abortBroadcast();
            return;

        } else if (intent.getAction().equals("com.jasshugarg.imusic.currsong")) {
            String str = intent.getStringExtra("currPlayingSong");


            Intent serviceIntent=new Intent(context,MyMusicService1.class);
            serviceIntent.putExtra("currPlayingSong",str);
            context.startService(serviceIntent);


            abortBroadcast();
            Log.d("MusicBroadcast", "aborted by 1  " );


            return;

        }


    }
}