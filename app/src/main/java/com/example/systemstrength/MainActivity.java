package com.example.systemstrength;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class MainActivity extends AppCompatActivity {
    //  Handler More used
    Handler apareceropcoes = new Handler ();
    Handler tempodeloading = new Handler ();
    RelativeLayout relativeprincipallogin, relativeinferiorlogin, relativeimgsystem;
    Button btncriarconta, btnesqueciasenha, btnlogaragora;
    ImageView imgolhoopenpassword, imgolhoclosepassword;
    EditText edittextsenha, edittextusuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ids
        relativeprincipallogin = (RelativeLayout)findViewById(R.id.relativeprincipallogin);
        relativeinferiorlogin = (RelativeLayout)findViewById(R.id.relativeinferiorlogin);
        relativeimgsystem = (RelativeLayout)findViewById(R.id.relativeimgsystem);
        btncriarconta = (Button) findViewById(R.id.btncriarconta);
        btnlogaragora = (Button) findViewById(R.id.btnlogaragora);
        btnesqueciasenha = (Button) findViewById(R.id.btnesqueciasenha);
        imgolhoopenpassword = (ImageView) findViewById(R.id.imgolhoopenpassword);
        imgolhoclosepassword = (ImageView) findViewById(R.id.imgolhoclosepassword);
        edittextsenha = (EditText) findViewById(R.id.edittextsenha);
        edittextusuario = (EditText) findViewById(R.id.edittextusuario);

        verificarnet();

        //  when starting an activity the ImageView will be GONE
        imgolhoclosepassword.setVisibility(View.GONE);

        //This is delay for timeout
        apareceropcoes.postDelayed(new Runnable() {
            @Override
            public void run() {
                //My two Relative Layouts
                relativeprincipallogin.setVisibility(View.VISIBLE);
                relativeinferiorlogin.setVisibility(View.VISIBLE);
            }
        },2000);

        //  Button CriarConta Press
        btncriarconta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irparaloading();
                tempodeloading.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent irparacriarconta = new Intent(MainActivity.this,CriarContaActivity.class);
                        startActivity(irparacriarconta);
                    }
                },400);
            }
        });

        //  Butoon Esqueci a Senha Press
        btnesqueciasenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irparaloading();
                tempodeloading.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent irparaesqueciasenha = new Intent(MainActivity.this,MenuEsqueciASenhaActivity.class);
                        startActivity(irparaesqueciasenha);
                    }
                },700);
            }
        });

        //  When you click on the open eye it will execute the defined commands
        imgolhoopenpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittextsenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                imgolhoopenpassword.setVisibility(View.GONE);
                imgolhoclosepassword.setVisibility(View.VISIBLE);
                edittextsenha.setSelection(edittextsenha.getText().length());
            }
        });

        //  When you click on the closed eye it will execute the defined commands
        imgolhoclosepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edittextsenha.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                imgolhoopenpassword.setVisibility(View.VISIBLE);
                imgolhoclosepassword.setVisibility(View.GONE);
                edittextsenha.setSelection(edittextsenha.getText().length());
            }
        });

        //  When making a change in the text of edittext it will execute a sequence of commands in real time
        edittextsenha.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edittextsenha.getText() == null || edittextsenha.getText().length() == 0){
                    imgolhoopenpassword.setVisibility(View.GONE);
                    imgolhoclosepassword.setVisibility(View.GONE);
                    edittextsenha.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (edittextsenha.getText().length() > 0){
                    imgolhoclosepassword.setVisibility(View.VISIBLE);
                }

            }
        });

        //  Clicking on the Logar Agora now will execute a series of defined commands
        btnlogaragora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittextusuario.getText() == null || edittextusuario.getText().length() < 5){
                    Toast.makeText(MainActivity.this, "Necessário preencher corretamente o campo: Usuario\nMinimo de caracteres: 5", Toast.LENGTH_SHORT).show();
                    edittextusuario.requestFocus();
                }
                else if (edittextsenha.getText() == null || edittextsenha.getText().length() < 5){
                    Toast.makeText(MainActivity.this, "Necessário preencher corretamente o campo: Senha\nMinimo de caracteres: 5", Toast.LENGTH_SHORT).show();
                    edittextsenha.requestFocus();
                }
                else {
                    //  Command will be defined when finalizing the 3 login screens
                }
            }
        });

    }

    public void verificarnet(){
        ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cn.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            btncriarconta.setEnabled(true);
            btnesqueciasenha.setEnabled(true);
            btnlogaragora.setEnabled(true);
        }
        else{
            btncriarconta.setEnabled(false);
            btnesqueciasenha.setEnabled(false);
            btnlogaragora.setEnabled(false);
            btnlogaragora.setTextColor(Color.RED);
            btnesqueciasenha.setTextColor(Color.RED);
            btncriarconta.setTextColor(Color.RED);
            AlertDialog.Builder aviso = new AlertDialog.Builder(MainActivity.this);
            aviso.setTitle("Opss.. :(");
            aviso.setIcon(R.mipmap.ic_launcher_system);
            aviso.setMessage("Você está sem conexão a internet\nNão será possivel acesar sua conta ou mesmo criar um!");
            aviso.setPositiveButton("OK", null);
            aviso.show();
        }
    }

    private void irparaloading(){
        Intent irparaloading = new Intent(MainActivity.this,LoadingActivity.class);
        startActivity(irparaloading);
    }
}

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/