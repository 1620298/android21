package com.example.proyectovideo2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnPlay;
    private Button btnPause;
    private Button btnStop;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                break;
            case R.id.buttonPause:
                video.pause();
                break;
            case R.id.buttonStop:
                video.suspend();
                video.seekTo(0);
                video.resume();
                video.pause();
                break;
        }

    }
}