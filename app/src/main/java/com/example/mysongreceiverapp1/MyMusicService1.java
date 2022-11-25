package com.example.mysongreceiverapp1;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class MyMusicService1 extends Service {
    public MyMusicService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        MyMusicReceiver1 musicBroadCastReceiver1 = new MyMusicReceiver1();
        IntentFilter intentFilter = new IntentFilter("com.jasshugarg.imusic.currsong");
        registerReceiver(musicBroadCastReceiver1, intentFilter);
        return super.onStartCommand(intent, flags, startId);
    }
}