package com.uvigo.learnfordown.learnfordown;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class lettergame4lvl_screen extends AppCompatActivity {
    TextView titulo;
    String Correcta="R";
    private RecyclerView horizontal_recycler_view;
    private ArrayList<String> horizontalList;
    private HorizontalAdapter horizontalAdapter;
    private RecyclerView horizontal_recycler_view2;
    private ArrayList<String> horizontalList2;
    private HorizontalAdapter horizontalAdapter2;
    ImageView palabra;
    GestionNiveles  gn;
    String tipoNivel="leerletras";
    ArrayList<FotoPalabra> fp;
    int i=0;
    int aciertos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lettergame4lvl_screen);
        Typeface face=Typeface.createFromAsset(getAssets(),"fonts/Berlin Sans FB Demi Bold.ttf");
        titulo = (TextView) findViewById(R.id.textView2);
        titulo.setTypeface(face);
        horizontal_recycler_view= (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        horizontal_recycler_view2= (RecyclerView) findViewById(R.id.horizontal_recycler_view2);
        titulo = (TextView) findViewById(R.id.textView2);
        titulo.setTypeface(face);
        palabra= (ImageView)findViewById(R.id.imageView2);

        Context context = this.getApplicationContext();
        gn = new GestionNiveles(context);
        gn.setNivel(tipoNivel,4);
        fp=gn.getFotos();

        horizontalList=new ArrayList<String>();
        gn.rellenarConletras(fp.get(i).getLetra().toUpperCase(),horizontalList);
        Collections.shuffle( horizontalList);
        palabra.setImageResource(fp.get(i).getFoto());
        Correcta= fp.get(i).getLetra().toUpperCase();


        horizontalAdapter=new HorizontalAdapter(horizontalList);

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(lettergame4lvl_screen.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        horizontalList2=new ArrayList<String>();
        gn.rellenarConletras(fp.get(i).getLetra().toUpperCase(),horizontalList2);
        Collections.shuffle( horizontalList2);
        horizontalAdapter2=new HorizontalAdapter(horizontalList2);

        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(lettergame4lvl_screen.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view2.setLayoutManager(horizontalLayoutManagaer2);





        horizontal_recycler_view.setAdapter(horizontalAdapter);


        horizontal_recycler_view2.setAdapter(horizontalAdapter2);
    }
    public void BackArrow (View v){
        Intent intent1 = new Intent(lettergame4lvl_screen.this, menu_screen.class);
        startActivity(intent1);
    }
    public void goHome (View v){
        Intent intent1 = new Intent(lettergame4lvl_screen.this, home_screen.class);
        startActivity(intent1);
    }
    public void ButtonCheck (View v) {
        Button b = (Button) v;
        String buttonText = b.getText().toString();
        if (Correcta.equals(buttonText)) {
            TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f,
                    -50.0f, 0.0f);
            animation.setDuration(2000);
            animation.setFillAfter(true);
            b.startAnimation(animation);
            b.setBackgroundColor(Color.GREEN);
            aciertos++;
            //Codigo de Animacion Acierto
            if (aciertos == 2) {
                gn.acierto();
                System.out.println("Se ha anotado un acierto");
                if (!gn.isnivelCompletado()) {
                    i++;
                    cambiarFoto();
                } else {
                    System.out.print("el nivel esta finalizado");
                    gn.avanzaNivel();
                    if (gn.getDificultad() != 4 || !(gn.getTipo().equals(tipoNivel))) {
                        System.out.println("Se debe abrir otra pantalla porque esta ya no vale");
                        //Código para abrir otra pantalla
                    } else {
                        fp = gn.getFotos();
                        i = 0;
                        cambiarFoto();
                        System.out.println("Se debe avanzar el nivel");
                    }

                }
                aciertos = 0;
            }
        } else {
            gn.fallo();
            //Codigo de Animacion Fallo

        }
    }
    private void cambiarFoto() {
        horizontalList.clear();
        horizontalList = new ArrayList<String>();
        gn.rellenarConletras(fp.get(i).getLetra().toUpperCase(),horizontalList);
        Collections.shuffle(horizontalList);

        horizontalList2.clear();
        horizontalList2 = new ArrayList<String>();
        gn.rellenarConletras(fp.get(i).getLetra().toUpperCase(),horizontalList2);
        Collections.shuffle(horizontalList2);

        palabra.setImageResource(fp.get(i).getFoto());
        Correcta= fp.get(i).getLetra().toUpperCase();
        horizontalAdapter = new HorizontalAdapter(horizontalList);
        horizontalAdapter2 = new HorizontalAdapter(horizontalList2);

        LinearLayoutManager horizontalLayoutManagaer = new LinearLayoutManager(lettergame4lvl_screen.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);

        LinearLayoutManager horizontalLayoutManagaer2 = new LinearLayoutManager(lettergame4lvl_screen.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view2.setLayoutManager(horizontalLayoutManagaer2);

        horizontal_recycler_view.setAdapter(horizontalAdapter);
        horizontal_recycler_view2.setAdapter(horizontalAdapter2);
    }


}

