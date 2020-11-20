package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

public class ServicosActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeservicos;
    CardView cardviewloadingprincipalservicos;
    String cpfrecebidoprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicos);
        linearbtnhomeservicos = findViewById(R.id.linearbtnhomeservicos);
        cardviewloadingprincipalservicos = findViewById(R.id.cardviewloadingprincipalservicos);

        //  Get some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidoprincipal = bundle.getString("cpfusu");

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