package com.example.primeractividad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText etNum1, etNum2;
    private TextView tvResultado;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1= (EditText)findViewById(R.id.etNum1);
        etNum2= (EditText)findViewById(R.id.etNum2);
        tvResultado= (TextView)findViewById(R.id.tvResultado);
        btn= (Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int num1, num2;
                num1= Integer.parseInt(etNum1.getText().toString());
                num2= Integer.parseInt(etNum2.getText().toString());
                int suma= num1+num2;
                tvResultado.setText("Resultado:"+suma);
            }
        });


    }
}