package com.uvigo.learnfordown.learnfordown;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class siinversas_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_siinversas_screen);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Berlin Sans FB Demi Bold.ttf");
    }
    public void BackArrow (View v){
        Intent intent1 = new Intent(siinversas_screen.this, menu_screen.class);
        startActivity(intent1);
    }
}
