package com.example.practicacalificada1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends Activity {
    private Bundle bundle;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResultado=(TextView)findViewById(R.id.tvResultado);
        bundle =getIntent().getExtras();
        int numero=Integer.parseInt(bundle.getString("numero"));

        int impar=1;
        int par=2;

        tvResultado.append("\r\n");
        tvResultado.append("Los primeros "+numero+" impares son: ");
        tvResultado.append("\r\n");
        //impar
        for (int i = 1; i <= numero; ++i) {
            tvResultado.append(""+impar+", ");
            impar=impar+2;
        }

        tvResultado.append("\r\n");
        tvResultado.append("Los primeros "+numero+" pares son: ");
        tvResultado.append("\r\n");
        //impar
        for (int i = 1; i <= numero; ++i) {
            tvResultado.append(""+par+", ");
            par=par+2;
        }





    }


}
