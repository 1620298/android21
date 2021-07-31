package com.example.imc;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class MainActivity3 extends Activity {

    private Bundle bundle;
    private TextView tvImc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        tvImc=(TextView)findViewById(R.id.tvImc);
        bundle =getIntent().getExtras();
        double peso=Double.parseDouble(bundle.getString("peso"));
        double altura=Double.parseDouble(bundle.getString("altura"));
        double imc=(peso/Math.pow(altura, 2));
        String riesgo;

        if (imc<18){
            riesgo="bajo peso, Aumentado";
        }else{
            if (imc<24.9){
                riesgo="normal, Normal";
            }else{
                if (imc<29.9){
                    riesgo="sobrepeso, Aumentado";
                }else{
                    if (imc<34.9){
                        riesgo="Obesidad I, Alto";
                    }else{
                        if (imc<39.9){
                            riesgo="Obesidad II, Muy Alto";
                        }else{
                            riesgo="Obesidad III, Extremadamente Alto";
                        }
                    }
                }
            }
        }


        tvImc.append("aea");
        tvImc.append("\r\n");
        for (int i = 0; i < 5; ++i) {
            tvImc.append("su imc es "+imc+"Resultado y riesgo: "+ riesgo);
        }

    }
}
