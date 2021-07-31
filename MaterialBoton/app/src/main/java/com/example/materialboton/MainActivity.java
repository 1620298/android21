package com.example.materialboton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomAppBar bottomAppBar;
    FloatingActionButton floatingActionButton;
    boolean esconderFab=false;
    boolean moverFab=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomAppBar=findViewById(R.id.bottomBar);
        setSupportActionBar(bottomAppBar);
        floatingActionButton=findViewById(R.id.fabBottomBar);


        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (esconderFab){
                    floatingActionButton.show();
                    esconderFab=false;
                }else {
                    floatingActionButton.hide();
                    esconderFab=true;
                }
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (moverFab){
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
                    moverFab=false;
                }else{
                    bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
                    moverFab=true;
                }
            }
        });

        public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()){
                case R.id.alarma:
                    Toast.makeText(this, "Alarma Activada", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.avion:
                    Toast.makeText(this, "Modo Avion activado", Toast.LENGTH_SHORT).show();
                    break;
            }

            return super.onOptionsItemSelected(item);
        }

        public boolean onCreateOptionsMenu(Menu menu){
            MenuInflater inflater =getMenuInflater();
            inflater.inflate(R.menu.menu item, menu);

            return true;
        }
    }
}