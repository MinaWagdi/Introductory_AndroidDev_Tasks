package com.cse437.mobcomputinglab4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    MediaPlayer ring;
    boolean ringFinished=true;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(ringFinished) {
            ringFinished=false;
            ring = MediaPlayer.create(this, R.raw.ringezra);
            ring.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    ringFinished=true;
                }
            });
            Log.i("MINA", "onStartCommang");

            ring.start();
            Toast.makeText(this, "onStartCommand started", Toast.LENGTH_SHORT).show();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy called", Toast.LENGTH_SHORT).show();
        Log.i("MINA","onDestroy" );
        ringFinished=true;
        ring.stop();
    }

    @Override
    public boolean stopService(Intent name) {
        ringFinished=true;
        return super.stopService(name);
    }
}
