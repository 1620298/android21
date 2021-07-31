package com.example.imc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity {
    private Bundle bundle;
    private TextView tvSaludo;
    private EditText edPeso;
    private EditText edAltura;
    private Button btnEnviarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edPeso = (EditText)findViewById(R.id.edPeso);
        edAltura = (EditText)findViewById(R.id.edAltura);
        btnEnviarDatos = (Button)findViewById(R.id.btnEnviarDatos);

        tvSaludo=(TextView)findViewById(R.id.tvSaludo);
        bundle =getIntent().getExtras();
        String saludo =bundle.getString("username");
        tvSaludo.append(" "+saludo+"!!!!");

        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edPeso.getText().equals(""))
                {
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    intent.putExtra("peso",edPeso.getText().toString());
                    intent.putExtra("altura",edAltura.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity2.this, "Debe indicar los datos requeridos", Toast.LENGTH_LONG).show();
                }

            }
        });


    }



}
