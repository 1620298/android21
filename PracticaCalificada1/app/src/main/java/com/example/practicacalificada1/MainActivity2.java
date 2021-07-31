package com.example.practicacalificada1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity2 extends Activity {
    private EditText edNumero;
    private Button btnEnviarDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edNumero = (EditText)findViewById(R.id.edNumero);
        btnEnviarDatos = (Button)findViewById(R.id.btnEnviarDatos);


        btnEnviarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edNumero.getText().toString().equals(""))
                {
                    Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                    intent.putExtra("numero",edNumero.getText().toString());
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
