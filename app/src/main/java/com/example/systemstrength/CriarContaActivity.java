package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class CriarContaActivity extends AppCompatActivity {
    
    Button btnvoltaraologin;
    EditText edittextusuariocadastro, edittextemailcadastro, edittexttelefonecadastro, edittextsenhacadastro;
    TextView txtusuario, txtemailcadastro, txttelefonecadastro, txtsenhacadastro, txtavisosenha, txtavisousuario;
    CardView cardviewbtncadastrar;
    ImageView imgsenharigth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criarconta);
        btnvoltaraologin = findViewById(R.id.btnvoltaraologin);
        edittextusuariocadastro = findViewById(R.id.edittextusuariocadastro);
        edittextemailcadastro = findViewById(R.id.edittextemailcadastro);
        edittexttelefonecadastro = findViewById(R.id.edittexttelefonecadastro);
        edittextsenhacadastro = findViewById(R.id.edittextsenhacadastro);
        txtusuario = findViewById(R.id.txtusuario);
        txtemailcadastro = findViewById(R.id.txtemailcadastro);
        txttelefonecadastro = findViewById(R.id.txttelefonecadastro);
        txtsenhacadastro = findViewById(R.id.txtsenhacadastro);
        cardviewbtncadastrar = findViewById(R.id.cardviewbtncadastrar);
        imgsenharigth = findViewById(R.id.imgsenharigth);
        txtavisosenha = findViewById(R.id.txtavisosenha);
        txtavisousuario = findViewById(R.id.txtavisousuario);

        imgsenharigth.setVisibility(View.GONE);
        txtavisosenha.setVisibility(View.GONE);
        txtavisousuario.setVisibility(View.GONE);

        //  Defining the mask to edittexttelefonecadastro
        edittexttelefonecadastro.addTextChangedListener(MaskEditUtil.mask(edittexttelefonecadastro, MaskEditUtil.FORMAT_FONE));

        //  By clicking on the login button to execute a sequence of configured commands
        btnvoltaraologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittextusuariocadastro.getText().length() > 0 || edittextemailcadastro.getText().length() > 0 || edittexttelefonecadastro.getText().length() > 0 || edittextsenhacadastro.getText().length() > 0) {
                    AlertDialog.Builder aviso = new AlertDialog.Builder(CriarContaActivity.this);
                    aviso.setTitle("Calma ai...");
                    aviso.setIcon(R.mipmap.ic_launcher_system);
                    aviso.setMessage("Aparentemente você começou um cadastro, se ir ao login ira perder todo o progresso até agora.\nDeseja realmente ir ao login?");
                    aviso.setNegativeButton("Não",null);
                    aviso.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    aviso.show();
                }
                else{
                    finish();
                }
            }
        });

        //  When inserted in the edittextusuario it will execute some commands in real time
        edittextusuariocadastro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edittextusuariocadastro.getText().length() != 0){
                    txtusuario.setText("Usuário");
                }
                if (edittextusuariocadastro.getText().length() == 0){
                    txtavisousuario.setVisibility(View.GONE);
                    txtusuario.setText(R.string.usuariocadastro);
                }
                if (edittextusuariocadastro.getText().length() >= 8){
                    txtavisousuario.setVisibility(View.GONE);
                }else{
                    txtavisousuario.setVisibility(View.VISIBLE);
                }
            }
        });

        //  When inserted in the edittextemail it will execute some commands in real time
        edittextemailcadastro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edittextemailcadastro.getText().length() != 0){
                    txtemailcadastro.setText("Email");
                }
                if (edittextusuariocadastro.getText().length() == 0){
                    txtemailcadastro.setText(R.string.email);
                }
            }
        });

        //  When inserted in the edittexttelefone it will execute some commands in real time
        edittexttelefonecadastro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edittexttelefonecadastro.getText().length() != 0){
                    txttelefonecadastro.setText("Telefone");
                }
                if (edittexttelefonecadastro.getText().length() == 0){
                    txttelefonecadastro.setText(R.string.telefone);
                }
            }
        });

        //  When inserted in the edittextsenha it will execute some commands in real time
        edittextsenhacadastro.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edittextsenhacadastro.getText().length() != 0){
                    txtsenhacadastro.setText("Senha");
                }
                if (edittextsenhacadastro.getText().length() == 0){
                    txtsenhacadastro.setText(R.string.senhacadastro);
                    txtavisosenha.setVisibility(View.GONE);
                }
                if (edittextsenhacadastro.getText().length() >= 8){
                    imgsenharigth.setVisibility(View.VISIBLE);
                    txtavisosenha.setVisibility(View.GONE);
                }else{
                    imgsenharigth.setVisibility(View.GONE);
                    txtavisosenha.setVisibility(View.VISIBLE);
                }
            }
        });

        cardviewbtncadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittextusuariocadastro.getText().length() == 0 || edittextusuariocadastro.getText().length() < 8){
                    Toast.makeText(CriarContaActivity.this, "O campo usuario não está preenchido corretamente", Toast.LENGTH_SHORT).show();
                    edittextusuariocadastro.requestFocus();
                }
                else if(edittextemailcadastro.getText().length() == 0 || edittextemailcadastro.getText().length() < 5){
                    Toast.makeText(CriarContaActivity.this, "O campo email não está preenchido corretamente", Toast.LENGTH_SHORT).show();
                    edittextemailcadastro.requestFocus();
                }
                else if(edittexttelefonecadastro.getText().length() == 0 || edittexttelefonecadastro.getText().length() < 15){
                    Toast.makeText(CriarContaActivity.this, "O campo telefone não está preenchido corretamente", Toast.LENGTH_SHORT).show();
                    edittexttelefonecadastro.requestFocus();
                }
                else if(edittextsenhacadastro.getText().length() == 0 || edittextsenhacadastro.getText().length() < 8){
                    Toast.makeText(CriarContaActivity.this, "O campo senha não está preenchido corretamente", Toast.LENGTH_SHORT).show();
                    edittextsenhacadastro.requestFocus();
                }
                else{

                }
            }
        });
    }
}

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/