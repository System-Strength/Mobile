package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

public class MainActivity extends AppCompatActivity {
    //  Handler More used
    Handler apareceropcoes = new Handler ();
    Handler tempodeloading = new Handler ();
    RelativeLayout relativeprincipallogin, relativeinferiorlogin, relativeimgsystem;
    Button btncriarconta, btnesqueciasenha;
    ImageView imgolhoopenpassword, imgolhoclosepassword;
    EditText edittextsenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ids
        relativeprincipallogin = (RelativeLayout)findViewById(R.id.relativeprincipallogin);
        relativeinferiorlogin = (RelativeLayout)findViewById(R.id.relativeinferiorlogin);
        relativeimgsystem = (RelativeLayout)findViewById(R.id.relativeimgsystem);
        btncriarconta = (Button) findViewById(R.id.btncriarconta);
        btnesqueciasenha = (Button) findViewById(R.id.btnesqueciasenha);
        imgolhoopenpassword = (ImageView) findViewById(R.id.imgolhoopenpassword);
        imgolhoclosepassword = (ImageView) findViewById(R.id.imgolhoclosepassword);
        edittextsenha = (EditText) findViewById(R.id.edittextsenha);

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
                },800);
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

    }

    private void irparaloading(){
        Intent irparaloading = new Intent(MainActivity.this,LoadingActivity.class);
        startActivity(irparaloading);
    }
}