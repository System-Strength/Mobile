package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    //  Handler More used
    Handler apareceropcoes = new Handler ();
    Handler tempodeloading = new Handler ();
    RelativeLayout relativeprincipallogin, relativeinferiorlogin, relativeimgsystem;
    Button btncriarconta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ids
        relativeprincipallogin = (RelativeLayout)findViewById(R.id.relativeprincipallogin);
        relativeinferiorlogin = (RelativeLayout)findViewById(R.id.relativeinferiorlogin);
        relativeimgsystem = (RelativeLayout)findViewById(R.id.relativeimgsystem);
        btncriarconta = (Button) findViewById(R.id.btncriarconta);

        //This is delay for timeout
        apareceropcoes.postDelayed(new Runnable() {
            @Override
            public void run() {
                //My two Relative Layouts
                relativeprincipallogin.setVisibility(View.VISIBLE);
                relativeinferiorlogin.setVisibility(View.VISIBLE);
            }
        },2000);

        btncriarconta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irparaloading();
                tempodeloading.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent irparacriarconta = new Intent(MainActivity.this,CriarContaActivity.class);
                        startActivity(irparacriarconta);
                    }
                },800);
            }
        });

    }

    private void irparaloading(){
        Intent irparaloading = new Intent(MainActivity.this,LoadingActivity.class);
        startActivity(irparaloading);
    }
}