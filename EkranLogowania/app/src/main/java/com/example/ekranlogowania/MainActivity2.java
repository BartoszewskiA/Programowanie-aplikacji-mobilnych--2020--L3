package com.example.ekranlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        info = findViewById(R.id.info);
        Bundle paczka = getIntent().getExtras();
        info.setText(paczka.getString("kto"));

    }
}