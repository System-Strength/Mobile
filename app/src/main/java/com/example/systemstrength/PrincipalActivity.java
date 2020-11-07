package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeprincipal, linearbtncontatoprincipal, linearbtnservicosprincipal;
    TextView txtnomeusu;
    CardView cardviewbtnmorenossaequipe;
    ImageView imgavatarusu;
    String nomeusu="Seu nome";
    String semnomeusu="Anonimo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        linearbtnhomeprincipal = findViewById(R.id.linearbtnhomeprincipal);
        linearbtncontatoprincipal = findViewById(R.id.linearbtncontatoprincipal);
        linearbtnservicosprincipal = findViewById(R.id.linearbtnservicosprincipal);
        txtnomeusu = findViewById(R.id.txtnomeusu);
        imgavatarusu = findViewById(R.id.imgavatarusu);
        cardviewbtnmorenossaequipe = findViewById(R.id.cardviewbtnmorenossaequipe);

        //  Get Name of user
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        nomeusu = bundle.getString("nomeusu");
        if (nomeusu.equals("")){
            txtnomeusu.setText(semnomeusu);
            Drawable drawable= getResources().getDrawable(R.drawable.iconeanonimos);
            imgavatarusu.setImageDrawable(drawable);
        }
        else{
            txtnomeusu.setText(nomeusu);
        }

        linearbtnhomeprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PrincipalActivity.this, "Você já está aqui!", Toast.LENGTH_SHORT).show();
            }
        });

        cardviewbtnmorenossaequipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irparanossaequipe = new Intent(PrincipalActivity.this,NossaEquipeActivity.class);
                startActivity(irparanossaequipe);
            }
        });
    }
}