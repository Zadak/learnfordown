package com.uvigo.learnfordown.learnfordown;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class frasedi_w_screen extends AppCompatActivity {
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frasedi_w_screen);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Berlin Sans FB Demi Bold.ttf");
        titulo = (TextView) findViewById(R.id.textView2);
        titulo.setTypeface(face);
    }
    public void BackArrow (View v){
        Intent intent1 = new Intent(frasedi_w_screen.this, menu_screen.class);
        startActivity(intent1);
    }
    public void nivel1(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, frasegame1lvl_w_screen.class);
        startActivity(intent);
    }
    public void goHome (View v){
        Intent intent1 = new Intent(frasedi_w_screen.this, home_screen.class);
        startActivity(intent1);

    }

}
