package com.example.systemmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView r1,r2,r3,r4;
    View WybranaRamka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        odnajdz();
    }

    private void odnajdz() {
        r1 = findViewById(R.id.imageView01);
        r2 = findViewById(R.id.imageView02);
        r3 = findViewById(R.id.imageView03);
        r4 = findViewById(R.id.imageView04);
        registerForContextMenu(r1);
        registerForContextMenu(r2);
        registerForContextMenu(r3);
        registerForContextMenu(r4);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.mainMenu01:
                setContentView(R.layout.activity_main);
                odnajdz();
                break;
            case R.id.mainMenu02:
                setContentView(R.layout.activity_main_dark);
                odnajdz();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu, menu);
        WybranaRamka = v;
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id)
        {
            case R.id.contextmenu01:
                Intent intencja = new Intent(this, MainActivity2.class);
                switch (WybranaRamka.getId())
                {
                    case R.id.imageView01:
                        intencja.putExtra("obraz",R.drawable.wilk01);
                        break;
                    case R.id.imageView02:
                        intencja.putExtra("obraz",R.drawable.wilk02);
                        break;
                    case R.id.imageView03:
                        intencja.putExtra("obraz",R.drawable.wilk03);
                        break;
                    case R.id.imageView04:
                        intencja.putExtra("obraz",R.drawable.wilk04);
                        break;
                }
                startActivity(intencja);
                break;
            case R.id.contextmenu02:
                Toast.makeText(this, "Dostępne w wersji premium", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}