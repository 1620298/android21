package com.example.proyectolistasensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salida=findViewById(R.id.salida);

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
            sensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores=sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (listaSensores.isEmpty()){
            Sensor acelerometroSensor=listaSensores.get(0);
            sensorManager.registerListener(this, acelerometroSensor, SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores=sensorManager.getSensorList(Sensor.TYPE_MAGNETIC_FIELD);
        if (!listaSensores.isEmpty()){
            Sensor magneticSensor=listaSensores.get(0);
            sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_UI);
        }

        listaSensores=sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!listaSensores.isEmpty()){
            Sensor proximidadSensor=listaSensores.get(0);
            sensorManager.registerListener(this, proximidadSensor, SensorManager.SENSOR_DELAY_UI);
        }
    }

    private void log(String string){
        salida.append(string+"\n");
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int precision) {

    }

    @Override
    public void onSensorChanged(SensorEvent evento) {
        switch (evento.sensor.getType()){
            case Sensor.TYPE_ORIENTATION:
                for (int i=0;i<3;i++)
                    log("Orientation"+ i +": "+ evento.values[i] );
                    break;
            case Sensor.TYPE_ACCELEROMETER:
                for (int i=0; i<3; i++)
                     log("Acelerometro"+i+": "+evento.values[i]);
                     break;
            case Sensor.TYPE_MAGNETIC_FIELD:
                for (int i=0;i <3;i++)
                    log("Proximidad"+ i+ ": "+evento.values[i]);
                break;
            default:
                for (int i=0; i<evento.values.length;i++)
                    log("Proximidad"+i+": "+ evento.values[i]);
                break;

            }
        }

    }
