package com.example.practicacalificada2;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class GirarActivity extends Activity {
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    int whip=0;
    private TextView salida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girar);
        salida=findViewById(R.id.salida);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorManager sensorManager =(SensorManager)
                getSystemService(SENSOR_SERVICE);


        List<Sensor> listaSensores =sensorManager.
                getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : listaSensores){
            log(sensor.getName());
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (!listaSensores.isEmpty()){
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener((SensorEventListener) this, orientationSensor, SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores=sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (listaSensores.isEmpty()){
            Sensor acelerometroSensor=listaSensores.get(0);
            sensorManager.registerListener((SensorEventListener) this, acelerometroSensor, SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores=sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (!listaSensores.isEmpty()){
            Sensor magneticSensor=listaSensores.get(0);
            sensorManager.registerListener((SensorEventListener) this, magneticSensor, SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores=sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!listaSensores.isEmpty()){
            Sensor proximidadSensor=listaSensores.get(0);
            sensorManager.registerListener((SensorEventListener) this, proximidadSensor, SensorManager.SENSOR_DELAY_UI);
        }

        if (sensor==null)
            finish();



        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x=sensorEvent.values[0];
                System.out.println("valor giro"+x);
                if (x<-5 && whip==0){
                    whip++;
                    switch (sensorEvent.sensor.getType()){
                        case Sensor.TYPE_ORIENTATION:
                            for (int i=0;i<3;i++)
                                log("Orientation"+ i +": "+ sensorEvent.values[i] );
                            break;
                        case Sensor.TYPE_ACCELEROMETER:
                            for (int i=0; i<3; i++)
                                log("Acelerometro"+i+": "+sensorEvent.values[i]);
                            break;
                        case Sensor.TYPE_MAGNETIC_FIELD:
                            for (int i=0;i <3;i++)
                                log("Magnetico"+ i+ ": "+sensorEvent.values[i]);
                            break;
                        default:
                            for (int i=0; i<sensorEvent.values.length;i++)
                                log("Proximidad"+i+": "+ sensorEvent.values[i]);
                            break;

                    }

                }else if (x>5 && whip==1){
                    whip++;
                    getWindow().getDecorView().setBackgroundColor(R.drawable.perro);
                }
                if (whip==2){
                    sound();
                    whip=0;
                }

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();

    }

    private void sound(){
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.latigo);
        mediaPlayer.start();
    }

    private void start(){
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }


    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    private void log(String string){
        salida.append(string+"\n");
    }


}

