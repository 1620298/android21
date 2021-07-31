package com.example.pp1areacilindro;

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

        etNum1=(EditText) findViewById(R.id.etNum1);
        etNum2=(EditText) findViewById(R.id.etNum2);
        tvResultado=(TextView) findViewById(R.id.tvResultado);
        btn =(Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double num1, num2;
                num1 = Double.parseDouble(etNum1.getText().toString());
                num2 = Double.parseDouble(etNum2.getText().toString());
                Double area= (3.14*(Math.pow(num1,2))*num2);
                tvResultado.setText("Resultado: "+area);
            }
        });
    }
}