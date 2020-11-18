package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.systemstrength.Classes.Login.DaoLogins;
import com.example.systemstrength.Classes.Login.DtoLogins;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeprincipal, linearbtnagendaprincipal, linearbtnservicosprincipal, linearbtnclienteprincipal;
    TextView txtnomeusu, txthoraatual, txtcargoatual, txtproximareuniao, txtplusclientes;
    //ImageView imgavatarusu;
    ConstraintLayout constraintlayoutperfilusu;
    LottieAnimationView animacaoservicoespricipal, animacaoagenda;
    CardView  loadingparaclientes, loadingparaagenda, loadingparaservicos, cardviewbtnverclientes, cardviewbtnlermaisjava, cardviewbtnlermaiscsharp, cardviewbtnlermaisjavascript, cardviewbtnlermaishtml, cardviewbtnlermaiscss;
    String cpfrecebido;
    String horarecebida;

    //  cardviewbtnlermaisjava
    //  cardviewbtnlermaiscsharp
    //  cardviewbtnlermaisjavascript
    //  cardviewbtnlermaishtml
    //  cardviewbtnlermaiscss


    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        linearbtnhomeprincipal = findViewById(R.id.linearbtnhomeprincipal);
        linearbtnagendaprincipal = findViewById(R.id.linearbtnagendaprincipal);
        linearbtnservicosprincipal = findViewById(R.id.linearbtnservicosprincipal);
        linearbtnclienteprincipal = findViewById(R.id.linearbtnclienteprincipal);
        constraintlayoutperfilusu = findViewById(R.id.constraintlayoutperfilusu);
        cardviewbtnverclientes = findViewById(R.id.cardviewbtnverclientes);
        loadingparaclientes = findViewById(R.id.loadingparaclientes);
        loadingparaservicos = findViewById(R.id.loadingparaservicos);
        loadingparaagenda = findViewById(R.id.loadingparaagenda);
        txtplusclientes = findViewById(R.id.txtplusclientes);
        animacaoservicoespricipal = findViewById(R.id.animacaoservicoespricipal);
        animacaoagenda = findViewById(R.id.animacaoagenda);
        txtnomeusu = findViewById(R.id.txtnomeusu);
        txthoraatual = findViewById(R.id.txthoraatual);
        //imgavatarusu = findViewById(R.id.imgavatarusu);
        txtcargoatual = findViewById(R.id.txtcargoatual);
        txtproximareuniao = findViewById(R.id.txtproximareuniao);

        //  Defining somethings with GONE

        //  Taking the current time and placing it on TextView
        horarecebida = new SimpleDateFormat("HH:mm").format(new Date());
        txthoraatual.setText(horarecebida);

        //  Get Name of user Turn on this later
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebido = bundle.getString("cpfusu");
        DaoLogins daoLogins = new DaoLogins(PrincipalActivity.this);
        DtoLogins dtoLogins = daoLogins.verificarusuario(cpfrecebido);
        txtnomeusu.setText(dtoLogins.getNomefunc());
        txtcargoatual.setText(dtoLogins.getCargofunc());
        if (dtoLogins.getUltamareufunc() == null || dtoLogins.getUltamareufunc().equals("")){
            txtproximareuniao.setText("Não há reunião agendada");
        }else {
            txtproximareuniao.setText(dtoLogins.getUltamareufunc());
        }

        constraintlayoutperfilusu.setOnClickListener(v -> {
            Intent irparaperfildeusuario = new Intent(PrincipalActivity.this,PerfilUsuarioActivity.class);
            irparaperfildeusuario.putExtra("cpfusu",cpfrecebido);
            startActivity(irparaperfildeusuario);
            finish();
        });

        cardviewbtnverclientes.setOnClickListener(v -> {
                Intent irparaclientes = new Intent(PrincipalActivity.this,ClientesActivity.class);
                irparaclientes.putExtra("cpfusu",cpfrecebido);
                startActivity(irparaclientes);
                finish();
        });

        linearbtnhomeprincipal.setOnClickListener(v -> Toast.makeText(PrincipalActivity.this, "Você já está aqui!", Toast.LENGTH_SHORT).show());

        linearbtnagendaprincipal.setOnClickListener(v -> {
            loadingparaagenda.setVisibility(View.VISIBLE);
            animacaoagenda.playAnimation();
            new Handler().postDelayed(() -> {
                loadingparaagenda.setVisibility(View.GONE);
                animacaoagenda.pauseAnimation();
                Intent irparaagenda = new Intent(PrincipalActivity.this,AgendaActivity.class);
                irparaagenda.putExtra("cpfusu",cpfrecebido);
                startActivity(irparaagenda);
                finish();
            },1700);
        });

        linearbtnservicosprincipal.setOnClickListener(v ->{
            loadingparaservicos.setVisibility(View.VISIBLE);
            animacaoservicoespricipal.setSpeed(2);
            new Handler().postDelayed(() -> {
                Toast.makeText(this, "Em Desenvolvimento!!!", Toast.LENGTH_SHORT).show();
                loadingparaservicos.setVisibility(View.GONE);
                /*Intent irparaclientes = new Intent(PrincipalActivity.this,ServicosActivity.class);
                irparaclientes.putExtra("cpfusu",cpfrecebido);
                startActivity(irparaclientes);
                finish();*/
            },1700);
        });

        linearbtnclienteprincipal.setOnClickListener(v -> {
            loadingparaclientes.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent irparaclientes = new Intent(PrincipalActivity.this,ClientesActivity.class);
                irparaclientes.putExtra("cpfusu",cpfrecebido);
                startActivity(irparaclientes);
                finish();
            },1500);
        });
    }
}

/*
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 */