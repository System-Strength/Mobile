package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class PrincipalActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeprincipal, linearbtncontatoprincipal, linearbtnservicosprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        linearbtnhomeprincipal = findViewById(R.id.linearbtnhomeprincipal);
        linearbtncontatoprincipal = findViewById(R.id.linearbtncontatoprincipal);
        linearbtnservicosprincipal = findViewById(R.id.linearbtnservicosprincipal);

        linearbtnhomeprincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PrincipalActivity.this, "Você já está aqui!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}