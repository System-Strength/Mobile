package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    TextView txtusuario, txtemailcadastro, txttelefonecadastro, txtsenhacadastro;
    CardView cardviewbtnprevisualizarcracha, cardviewbtncadastrar;

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
        cardviewbtnprevisualizarcracha = findViewById(R.id.cardviewbtnprevisualizarcracha);
        cardviewbtncadastrar = findViewById(R.id.cardviewbtncadastrar);

        //  Defining the mask to edittexttelefonecadastro
        edittexttelefonecadastro.addTextChangedListener(MaskEditUtil.mask(edittexttelefonecadastro, MaskEditUtil.FORMAT_FONE));

        //  Defining cardviewprevisualizar how GONE
        cardviewbtnprevisualizarcracha.setVisibility(View.GONE);

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
                    habilitarprevisualizacao();
                }
                if (edittextusuariocadastro.getText().length() == 0){
                    txtusuario.setText(R.string.usuariocadastro);
                    habilitarprevisualizacao();
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
                    habilitarprevisualizacao();
                }
                if (edittextusuariocadastro.getText().length() == 0){
                    txtemailcadastro.setText(R.string.email);
                    habilitarprevisualizacao();
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
                    habilitarprevisualizacao();
                }
                if (edittexttelefonecadastro.getText().length() == 0){
                    txttelefonecadastro.setText(R.string.telefone);
                    habilitarprevisualizacao();
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
                    habilitarprevisualizacao();
                }
                if (edittextsenhacadastro.getText().length() == 0){
                    txtsenhacadastro.setText(R.string.senhacadastro);
                    habilitarprevisualizacao();
                }
            }
        });
    }

    //  Method responsible for checking the number of digits in the edits and executing the defined command
    private void habilitarprevisualizacao(){
        if(edittextusuariocadastro.getText().length() >= 5 && edittextemailcadastro.getText().length() >= 8 && edittexttelefonecadastro.getText().length() == 15 && edittextsenhacadastro.getText().length() >= 8){
            cardviewbtnprevisualizarcracha.setVisibility(View.VISIBLE);
        }
        else {
            cardviewbtnprevisualizarcracha.setVisibility(View.GONE);
        }
    }
}

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/