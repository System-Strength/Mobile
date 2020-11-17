package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class CadastrodeClientesActivity extends AppCompatActivity {
    LinearLayout linearvoltaraoclientes;
    LottieAnimationView setinhaanimada,  checkedanimation2, checkedanimation1;
    CardView cardviewbtnsalvarnovocliente;
    TextView txtcadastrarbtnsalvar;
    String cpfrecebidodosclientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrode_clientes);
        linearvoltaraoclientes = findViewById(R.id.linearvoltaraoclientes);
        setinhaanimada = findViewById(R.id.setinhaanimada);
        checkedanimation2 = findViewById(R.id.checkedanimation2);
        checkedanimation1 = findViewById(R.id.checkedanimation1);
        txtcadastrarbtnsalvar = findViewById(R.id.txtcadastrarbtnsalvar);
        cardviewbtnsalvarnovocliente = findViewById(R.id.cardviewbtnsalvarnovocliente);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidodosclientes = bundle.getString("cpfusu");

        cardviewbtnsalvarnovocliente.setOnClickListener(v -> {
            txtcadastrarbtnsalvar.setVisibility(View.GONE);
            checkedanimation1.setVisibility(View.VISIBLE);
            checkedanimation1.playAnimation();
            new Handler().postDelayed(() -> {
                checkedanimation1.setVisibility(View.GONE);
                checkedanimation2.setVisibility(View.VISIBLE);
                checkedanimation2.playAnimation();
            },1000);
        });

        linearvoltaraoclientes.setOnClickListener(v -> {
            setinhaanimada.playAnimation();
            new Handler().postDelayed(() -> {
                Intent voltaraosclientes = new Intent(CadastrodeClientesActivity.this,ClientesActivity.class);
                voltaraosclientes.putExtra("cpfusu",cpfrecebidodosclientes);
                startActivity(voltaraosclientes);
                finish();
            },900);
        });
    }

    @Override
    public void onBackPressed() {
        Intent voltaraosclientes = new Intent(CadastrodeClientesActivity.this,ClientesActivity.class);
        voltaraosclientes.putExtra("cpfusu",cpfrecebidodosclientes);
        startActivity(voltaraosclientes);
        finish();
    }
}