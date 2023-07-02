package com.example.buttonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    private Button colorButton;
    private View layoutConst;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorButton = findViewById(R.id.colorButton);
        layoutConst = findViewById(R.id.layoutConst);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("M. Fajar Ihsan");

        colorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int acak = generateRandomColor();
                colorButton.setBackgroundColor(acak);
                layoutConst.setBackgroundColor(acak * 2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_item1) {
            // Lakukan sesuatu untuk menu_item1
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            return true;
        } else if (item.getItemId() == R.id.submenu_item1) {
            // Lakukan sesuatu untuk submenu_item1
            Toast.makeText(this, "Submenu 1 diklik", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.submenu_item2) {
            // Lakukan sesuatu untuk submenu_item2
            Toast.makeText(this, "Submenu 2 diklik", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }

    private int generateRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return Color.rgb(r, g, b);
    }
}
