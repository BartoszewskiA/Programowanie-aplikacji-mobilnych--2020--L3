package com.example.ekranlogowania;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   EditText poleUser, polePassword;
   Button przyciskLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poleUser =  findViewById(R.id.username);
        polePassword = findViewById(R.id.password);
        przyciskLogin = findViewById(R.id.login);
        przyciskLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sprawdzZaloguj();
            }
        });
    }

    private void sprawdzZaloguj() {
        Intent intencja = new Intent(this, MainActivity2.class);
        intencja.putExtra("kto", poleUser.getText().toString());
        startActivity(intencja);
    }
}