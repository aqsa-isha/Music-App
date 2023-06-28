package com.example.musicapp;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;
import androidx.annotation.Nullable;
public class NewService extends Service {
    private MediaPlayer player;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create( this, Settings.System.DEFAULT_RINGTONE_URI );
        player.setLooping( true );
        player.start();
        return START_STICKY;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
        MediaPlayer player = MediaPlayer.create(this, R.raw.bell);
        player.setLooping(false); // Set looping
    }
    @Override
    public void onStart(Intent intent, int startid) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        player.start();
    }
    @Override
// execution of the service will stop on callingthis method
    public void onDestroy() {
        super.onDestroy();
// stopping the process
        player.stop();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
