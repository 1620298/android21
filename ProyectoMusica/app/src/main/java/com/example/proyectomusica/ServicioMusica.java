package com.example.proyectomusica;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class ServicioMusica extends Service {
    MediaPlayer reproductor;
    private static final int ID_NOTIFICACION_CREAR=1;

    @Override
    public void onCreate(){
        Toast.makeText(this, "Servicio creado",
                Toast.LENGTH_SHORT).show();
        reproductor=MediaPlayer.create(this, R.raw.te_veo);
    }

    @Override
    public int onStartCommand(Intent intenc, int flags, int idArranque){

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
                new Intent(this, MainActivity.class), 0);
        notific.setContentIntent(intencionPendiente);
        //

        Toast.makeText(this, "Servicio arrancado "+idArranque,
                Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy(){

        //notify
        NotificationManager notificationManager=(NotificationManager)
            getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(ID_NOTIFICACION_CREAR);
        //

        Toast.makeText(this, "Servicio detenido",
                Toast.LENGTH_SHORT).show();

        reproductor.stop();
    }

    @Override
    public IBinder onBind(Intent intencion) {
        return null;
    }
}
