package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void lied(View v){

        Intent i = new Intent(this, Lied.class);
        startActivity(i);
    }
    public void sport(View v){

        Intent s = new Intent(this, Workout.class);
        startActivity(s);
    }

    public void gesprekken(View v ){

        Intent t = new Intent(this, Talking.class);
        startActivity(t);
    }
}