package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class EdicaoAgendaActivity extends AppCompatActivity {
    String cpfrecebidodaagenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_agenda);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidodaagenda = bundle.getString("cpfusu");
    }

    @Override
    public void onBackPressed() {
        Intent voltaraosclientes = new Intent(EdicaoAgendaActivity.this,AgendaActivity.class);
        voltaraosclientes.putExtra("cpfusu",cpfrecebidodaagenda);
        startActivity(voltaraosclientes);
        finish();
    }
}