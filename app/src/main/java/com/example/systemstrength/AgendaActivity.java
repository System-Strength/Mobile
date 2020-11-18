package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class AgendaActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeagenda;
    CardView cardviewloadingpricipalagenda, cardviewnovoagendamento, cardviewanimacaonovoagendamento;
    String cpfrecebidobase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        linearbtnhomeagenda = findViewById(R.id.linearbtnhomeagenda);
        cardviewloadingpricipalagenda = findViewById(R.id.cardviewloadingpricipalagenda);
        cardviewnovoagendamento = findViewById(R.id.cardviewnovoagendamento);
        cardviewanimacaonovoagendamento = findViewById(R.id.cardviewanimacaonovoagendamento);

        //  Get some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidobase = bundle.getString("cpfusu");

        cardviewnovoagendamento.setOnClickListener(v -> {
            cardviewnovoagendamento.setVisibility(View.GONE);
            cardviewanimacaonovoagendamento.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent irparanovoagendamento = new Intent(AgendaActivity.this,NovoAgendamentoActivity.class);
                irparanovoagendamento.putExtra("cpfusu",cpfrecebidobase);
                startActivity(irparanovoagendamento);
                finish();
            },1500);
        });

        //  When click in this linear you will go to Principal Activity
        linearbtnhomeagenda.setOnClickListener(v ->{
            cardviewloadingpricipalagenda.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent voltarparaprincipal = new Intent(AgendaActivity.this,PrincipalActivity.class);
                voltarparaprincipal.putExtra("cpfusu",cpfrecebidobase);
                startActivity(voltarparaprincipal);
                finish();
            },1500);
        });
    }
}