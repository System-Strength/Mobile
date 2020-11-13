package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class PerfilUsuarioActivity extends AppCompatActivity {
    LinearLayout linearbtnvoltarperfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        //  Ids
        linearbtnvoltarperfil = findViewById(R.id.linearbtnvoltarperfil);
    }
}