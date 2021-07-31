package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText edUsername;
    private EditText edPassword;
    private Button btnEnviarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edUsername =(EditText)findViewById(R.id.edUsername);
        edUsername =(EditText)findViewById(R.id.edPassword);
        btnEnviarLogin = (Button)findViewById(R.id.btnEnviarLogin);


        btnEnviarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edUsername.getText().equals("")){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    intent.putExtra("username",edUsername.getText().toString());
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "volver a ingresar los datos", Toast.LENGTH_LONG).show();
                }


            }
        });


    }
}