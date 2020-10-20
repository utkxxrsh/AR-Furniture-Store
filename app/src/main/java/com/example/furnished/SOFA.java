package com.example.furnished;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SOFA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sof);
    }
    public void ar1(View view){
        startActivity(new Intent(getApplicationContext(),sofar.class));
    }
}

