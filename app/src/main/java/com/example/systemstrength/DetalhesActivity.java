package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.systemstrength.Classes.Clientes.DaoClientes;
import com.example.systemstrength.Classes.Clientes.DtoClientes;

public class DetalhesActivity extends AppCompatActivity {
    TextView txtnomecliente, txtendcliente, txtphonecliente, txtemailcliente, txtcnpcliente;
    LinearLayout linearvoltaraoclientesdetalhes, linearbtnstarteditcliente;
    LottieAnimationView setinhaanimadadetahles;
    CardView cardviewbtnsalvaraltercliente;
    String cnpjrecebidodocliente, cpfusuariorecebidodosclientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        //  Ids
        txtnomecliente = findViewById(R.id.txtnomecliente);
        txtendcliente = findViewById(R.id.txtendcliente);
        txtphonecliente = findViewById(R.id.txtphonecliente);
        txtemailcliente = findViewById(R.id.txtemailcliente);
        txtcnpcliente = findViewById(R.id.txtcnpcliente);
        linearvoltaraoclientesdetalhes = findViewById(R.id.linearvoltaraoclientesdetalhes);
        linearbtnstarteditcliente = findViewById(R.id.linearbtnstarteditcliente);
        setinhaanimadadetahles = findViewById(R.id.setinhaanimadadetahles);
        cardviewbtnsalvaraltercliente = findViewById(R.id.cardviewbtnsalvaraltercliente);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cnpjrecebidodocliente = bundle.getString("cnjdaempresa");
        cpfusuariorecebidodosclientes = bundle.getString("cpfusu");

        DaoClientes daoClientes = new DaoClientes(DetalhesActivity.this);
        DtoClientes dtoClientes = daoClientes.consultarcliente(cnpjrecebidodocliente);
        txtnomecliente.setText(dtoClientes.getNomecliente());
        txtendcliente.setText(dtoClientes.getEnderecocliente());
        txtphonecliente.setText(dtoClientes.getTelefonecliente());
        txtemailcliente.setText(dtoClientes.getEmailcliente());
        txtcnpcliente.setText(dtoClientes.getCnpjcliente());

        linearbtnstarteditcliente.setOnClickListener(v -> {

        });

        //  When Click in this linear go to Clientes and send cpf of client
        linearvoltaraoclientesdetalhes.setOnClickListener(v -> {
            setinhaanimadadetahles.playAnimation();
            new Handler().postDelayed(() -> {
                Intent voltaraosclientes = new Intent(DetalhesActivity.this,ClientesActivity.class);
                voltaraosclientes.putExtra("cpfusu",cpfusuariorecebidodosclientes);
                startActivity(voltaraosclientes);
            },800);
        });
    }
}