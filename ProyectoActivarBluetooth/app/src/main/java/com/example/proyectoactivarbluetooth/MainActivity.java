package com.example.proyectoactivarbluetooth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int CODIGO_SOLICITUD_PERMISO=1;
    private static final int CODIGO_SOLICITUD_HABILITAR_BLUETOOTH=0;
    private Context context;
    private Activity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=getApplicationContext();
        activity=this;
    }

    public void habilitarBluetooth(View v){
        solicitarPermiso();
        BluetoothAdapter mBluetoothAdapater=BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapater==null){
            Toast.makeText(context, "Tu dispositivo no tiene Bluetooth", Toast.LENGTH_SHORT).show();
        }
        if (!mBluetoothAdapater.isEnabled()){
            Intent habilitarBluetoothIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(habilitarBluetoothIntent, CODIGO_SOLICITUD_HABILITAR_BLUETOOTH);
        }
    }

    public boolean verificarStatusPermiso(){
        int resultado= ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH);
        if (resultado== PackageManager.PERMISSION_GRANTED){
            return true;
        }
        else{
            return false;
        }
    }

    public void solicitarPermiso() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH)){
            Toast.makeText(MainActivity.this, "El permiso ya fue otorgado, si deseas activarlo"+
                    "debes ir a los ajustes de la aplicacion", Toast.LENGTH_SHORT).show();
        }
        else{
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.BLUETOOTH},
                    CODIGO_SOLICITUD_PERMISO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        switch (requestCode){
            case CODIGO_SOLICITUD_PERMISO:
                if (verificarStatusPermiso()){
                    Toast.makeText(MainActivity.this, "No esta activado el permiso para Bluetooth",
                            Toast.LENGTH_LONG).show();
                }
        }
    }




}