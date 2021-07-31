package com.example.proyectoservicioweb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button btnConsultar, btnGuardar;
    EditText etId, etNombres, etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConsultar=findViewById(R.id.btnConsultar);
        btnGuardar=findViewById(R.id.btnGuardar);
        etId=findViewById(R.id.etId);
        etNombres=findViewById(R.id.etNombres);
        etTelefono=findViewById(R.id.etTelefono);


        btnGuardar.setOnClickListener(v -> {

        });

        btnGuardar.setOnClickListener(v -> {
            new CargarDatos().execute("http://10.0.2.2/CursoAndroid/registro.php?nombres="+etNombres.getText().toString()+"&telefono="+etTelefono.getText().toString());
        });

        btnConsultar.setOnClickListener(v -> {
            new ConsultarDatos().execute("http://10.0.2.2/CursoAndroid/consulta.php?id="+etId.getText().toString());
        });

        //btnConsultar.setOnClickListener((v) -> {
          //  new ConsultarDatos().execute("http://10.0.2.2/CursoAndroid/consulta.php?id="+etId.getText().toString());
        //});

        //btnGuardar.setOnClickListener((v) -> {
          //  new CargarDatos().execute("http://10.0.2.2/CursoAndroid/registro.php?nombres="+etNombres.getText().toString()+"&telefono="+etTelefono.getText().toString());
        //});
    }

    private class CargarDatos extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            try {
                return downloadUrl(urls[0]);
            }catch (IOException e){
                return "Unable to retrieve web page. URL may be invalid";
            }

        }

        @Override
        protected void onPostExecute(String result){
            Toast.makeText(getApplicationContext(), "Se almacenaron los datos correctamente", Toast.LENGTH_LONG).show();
        }
    }

    private class ConsultarDatos extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... urls) {
            try {
                return downloadUrl(urls[0]);
            }catch (IOException e){
                return "Unable to retrieve web page. URL may be invalid";
            }
        }

        @Override
        protected void onPostExecute(String result){
            JSONArray ja=null;
            try {
                ja = new JSONArray(result);
                etNombres.setText(ja.getString(1));
                etTelefono.setText(ja.getString(2));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private String downloadUrl(String myurl) throws IOException{
        Log.i("URL", ""+myurl);
        myurl=myurl.replace(" ", "%20");
        InputStream is = null;
        int len=500;

        try {
            URL url = new URL(myurl);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);

            conn.connect();
            int response=conn.getResponseCode();
            Log.d("respuesta", "The response is: "+ response);
            is=conn.getInputStream();

            String contentAsString=readIt(is, len);
            return contentAsString;
        }finally {
            if (is!=null){
                is.close();
            }
        }
    }

    private String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }


}