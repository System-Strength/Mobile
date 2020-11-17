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

public class ClientesActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeclientes, linearbtnclientes;
    CardView cardviewloadingprincipal, cardviewalertyouarehere, cardviewanimacaocadastronovocliente, cardviewcadastrarnovocliente;
    LottieAnimationView smileanimationalert;
    String cpfrecebidodaprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        linearbtnhomeclientes = findViewById(R.id.linearbtnhomeclientes);
        linearbtnclientes = findViewById(R.id.linearbtnclientes);
        cardviewloadingprincipal = findViewById(R.id.cardviewloadingprincipal);
        cardviewalertyouarehere = findViewById(R.id.cardviewalertyouarehere);
        smileanimationalert = findViewById(R.id.smileanimationalert);
        cardviewcadastrarnovocliente = findViewById(R.id.cardviewcadastrarnovocliente);
        cardviewanimacaocadastronovocliente = findViewById(R.id.cardviewanimacaocadastronovocliente);

        //  Get Some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidodaprincipal = bundle.getString("cpfusu");

        cardviewcadastrarnovocliente.setOnClickListener(v ->{
            cardviewanimacaocadastronovocliente.setVisibility(View.VISIBLE);
            cardviewcadastrarnovocliente.setVisibility(View.GONE);
            new Handler().postDelayed(() -> {
                Intent irparacadastrodecliente = new Intent(ClientesActivity.this,CadastrodeClientesActivity.class);
                irparacadastrodecliente.putExtra("cpfusu",cpfrecebidodaprincipal);
                startActivity(irparacadastrodecliente);
                finish();
            },1200);
        });

        //  When you click in this linear go do one animation and go to PrincipalActivity
        linearbtnhomeclientes.setOnClickListener(v ->{
            cardviewloadingprincipal.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent voltarparaprincipal = new Intent(ClientesActivity.this,PrincipalActivity.class);
                voltarparaprincipal.putExtra("cpffunc",cpfrecebidodaprincipal);
                startActivity(voltarparaprincipal);
                finish();
            },1500);
        });

        //  When Click in this linear will show one msg and do one animation
        linearbtnclientes.setOnClickListener(v -> {
            Toast.makeText(this, "Você já esta aqui :)", Toast.LENGTH_SHORT).show();
            cardviewalertyouarehere.setVisibility(View.VISIBLE);
            smileanimationalert.playAnimation();
            new Handler().postDelayed(() -> {
                cardviewalertyouarehere.setVisibility(View.GONE);
                smileanimationalert.pauseAnimation();

            },2000);
        });
    }
}