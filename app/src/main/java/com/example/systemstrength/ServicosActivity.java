package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class ServicosActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeservicos, linearbtnclientesservicos, linearbtncontatoservicos, linearbtnservicosservicos;
    CardView cardviewloadingprincipalservicos, loadingparaclientesservicos, loadingparaagendaservicos, cardviewbtnmoreequipe;
    String cpfrecebidoprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);
        linearbtnhomeservicos = findViewById(R.id.linearbtnhomeservicos);
        linearbtnclientesservicos = findViewById(R.id.linearbtnclientesservicos);
        linearbtncontatoservicos = findViewById(R.id.linearbtncontatoservicos);
        linearbtnservicosservicos = findViewById(R.id.linearbtnservicosservicos);
        cardviewloadingprincipalservicos = findViewById(R.id.cardviewloadingprincipalservicos);
        loadingparaclientesservicos = findViewById(R.id.loadingparaclientesservicos);
        loadingparaagendaservicos = findViewById(R.id.loadingparaagendaservicos);
        cardviewbtnmoreequipe = findViewById(R.id.cardviewbtnmoreequipe);

        //  Get some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidoprincipal = bundle.getString("cpfusu");

        cardviewbtnmoreequipe.setOnClickListener(v -> {
            Intent iranossaequipe = new Intent(ServicosActivity.this,NossaEquipeActivity.class);
            iranossaequipe.putExtra("cpfusu",cpfrecebidoprincipal);
            startActivity(iranossaequipe);
            finish();
        });

        //  When click in this linear you will show some msg
        linearbtnservicosservicos.setOnClickListener(v -> Toast.makeText(this, "Você já esta aqui :)", Toast.LENGTH_SHORT).show());

        //  When click in this linear you will be back to AgendaActivity
        linearbtncontatoservicos.setOnClickListener(v -> {
            loadingparaagendaservicos.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent irparaagenda = new Intent(ServicosActivity.this,AgendaActivity.class);
                irparaagenda.putExtra("cpfusu",cpfrecebidoprincipal);
                startActivity(irparaagenda);
                finish();
            },1200);
        });

        //  When click in this linear you will be back to ClienteActivity
        linearbtnclientesservicos.setOnClickListener(v -> {
            loadingparaclientesservicos.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent irparaclientes = new Intent(ServicosActivity.this,ClientesActivity.class);
                irparaclientes.putExtra("cpfusu",cpfrecebidoprincipal);
                startActivity(irparaclientes);
                finish();
            },1200);
        });

        //  When click in this linear you will be back to principal activity
        linearbtnhomeservicos.setOnClickListener(v -> {
            cardviewloadingprincipalservicos.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent voltarparaprincipal = new Intent(ServicosActivity.this,PrincipalActivity.class);
                voltarparaprincipal.putExtra("cpfusu",cpfrecebidoprincipal);
                startActivity(voltarparaprincipal);
                finish();
            },1500);
        });
    }
}