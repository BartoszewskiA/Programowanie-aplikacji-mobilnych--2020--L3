package com.example.gestylicznik;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements GestureDetector.OnGestureListener {

    GestureDetector detektorGestow;
    TextView poleLicznik;
    int licznik=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        poleLicznik = findViewById(R.id.textView01);
        detektorGestow = new GestureDetector(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detektorGestow.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {

        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        licznik=0;
        poleLicznik.setText(String.valueOf(licznik));
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //poleLicznik.setText(String.valueOf(v)+"\n"+String.valueOf(v1));
        float dy = motionEvent1.getY() - motionEvent.getY();
        float dx = motionEvent1.getX() - motionEvent.getX();
        //poleLicznik.setText(String.valueOf(dy));
        if (dy>0)
            licznik--;
        else
            licznik++;
        poleLicznik.setText(String.valueOf(licznik));
        return false;
    }
}