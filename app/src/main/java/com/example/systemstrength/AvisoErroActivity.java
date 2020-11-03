package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AvisoErroActivity extends AppCompatActivity {
    LinearLayout linearbtnvoltaravisoerro;
    CardView cardviewbtncontatoavisoerro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviso_erro);
        linearbtnvoltaravisoerro = findViewById(R.id.linearbtnvoltaravisoerro);
        cardviewbtncontatoavisoerro = findViewById(R.id.cardviewbtncontatoavisoerro);

        linearbtnvoltaravisoerro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        cardviewbtncontatoavisoerro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Soon
            }
        });

    }
}