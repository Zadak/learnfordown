package com.uvigo.learnfordown.learnfordown;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sidirectas_w_screen extends AppCompatActivity {
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidirectas_w_screen);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Berlin Sans FB Demi Bold.ttf");
        //titulo = (TextView) findViewById(R.id.textView2);
        //titulo.setTypeface(face);
    }
    public void BackArrow (View v){
        Intent intent1 = new Intent(sidirectas_w_screen.this, menu_write_screen.class);
        startActivity(intent1);
    }
    public void goHome (View v){
        Intent intent1 = new Intent(sidirectas_w_screen.this, home_screen.class);
        startActivity(intent1);
    }

    public void nivel1(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, silabasgame1lvl_w_screen.class);
        startActivity(intent);
    }

    public void nivel2(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, silabasgame2lvl_w_screen.class);
        startActivity(intent);
    }

    public void nivel3(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, silabasgame3lvl_w_screen.class);
        startActivity(intent);
    }

    public void nivel4(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, silabasgame4lvl_w_screen.class);
        startActivity(intent);
    }
}

