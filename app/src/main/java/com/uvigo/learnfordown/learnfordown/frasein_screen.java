package com.uvigo.learnfordown.learnfordown;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class frasein_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frasein_screen);
    }
    public void BackArrow (View v){
        Intent intent1 = new Intent(frasein_screen.this, menu_screen.class);
        startActivity(intent1);
    }

    public void nivel1(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, frasegame1lvl_screen.class);
        startActivity(intent);
    }
}