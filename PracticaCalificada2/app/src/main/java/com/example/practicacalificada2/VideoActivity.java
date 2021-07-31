package com.example.practicacalificada2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private VideoView video;
    private static final int ID_NOTIFICACION_CREAR=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //iniciamos la clase

        video=(VideoView)findViewById(R.id.videoView);
        String path="android.resource://"+getPackageName()+"/"+R.raw.martian_wrinkle;
        video.setVideoURI(Uri.parse(path));

        //obtnemos los tres botonoes
        btnPlay=findViewById(R.id.buttonPlay);
        btnStop=findViewById(R.id.buttonStop);
        btnPause=findViewById(R.id.buttonPause);

        //controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPause.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //identificador del botom
        switch (v.getId()){
            case R.id.buttonPlay:

                video.start();
//notify
                NotificationCompat.Builder notific=new NotificationCompat.Builder(this, " ");
                notific.setContentTitle("Creando servicio de musica")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources()
                                , android.R.drawable.ic_media_play))
                        .setContentInfo("mas info")
                        .setTicker("Notification")
                        .setContentText("informacion adicional");
                NotificationManager notificationManager=(NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(ID_NOTIFICACION_CREAR, notific.build());

                PendingIntent intencionPendiente=PendingIntent.getActivity(this, 0,
                        new Intent(this, VideoActivity.class), 0);
                notific.setContentIntent(intencionPendiente);
                //
                Toast.makeText(this, "Servicio arrancado ",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonPause:
                video.pause();
                //notify
                notificationManager = (NotificationManager)
                        getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancel(ID_NOTIFICACION_CREAR);
                //
                Toast.makeText(this, "Servicio pausado",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonStop:
                video.suspend();
                video.seekTo(0);
                video.resume();
                video.pause();
                Toast.makeText(this, "Servicio detenido",
                        Toast.LENGTH_SHORT).show();
                break;
        }

    }


}