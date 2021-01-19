package com.example.l3cw03p01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText p1,p2;
    double kwotaPLN=0, kwotaEURO=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        p1 = findViewById(R.id.editText01);
        p2 = findViewById(R.id.editText02);
    }

    public void przelicz(View view) {
        String s = p1.getText().toString();
        if (s.length()==0) s="0";
        kwotaPLN = Double.parseDouble(s);
        kwotaEURO = kwotaPLN / 4.5;
        p2.setText(String.valueOf(kwotaEURO));
    }

    public  void przelicz2(View view) {
        String s1 = p1.getText().toString();
        String s2 = p2.getText().toString();

        if (s1.length()>0)
        {
            kwotaPLN = Double.parseDouble(s1);
            kwotaEURO = kwotaPLN / 4.5;
            p2.setText(String.valueOf(kwotaEURO));
        } else if(s2.length()>0)
        {
            kwotaEURO = Double.parseDouble(s2);
            kwotaPLN = kwotaEURO * 4.5;
            p1.setText(String.valueOf(kwotaPLN));
        } else
        {
            p1.setText("0");
            p2.setText("0");
        }
    }

    public void reset(View view) {
        kwotaPLN=0;
        kwotaEURO=0;
        p1.setText("");
        p2.setText("");
    }
}