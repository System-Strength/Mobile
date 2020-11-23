package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.systemstrength.Classes.Agenda.DaoAgenda;
import com.example.systemstrength.Classes.Agenda.DtoAgenda;
import com.example.systemstrength.Classes.Clientes.DaoClientes;
import com.example.systemstrength.Classes.Clientes.DtoClientes;

import java.util.ArrayList;

public class EdicaoAgendaActivity extends AppCompatActivity {
    EditText edittextclienteedit, edittextcnpjclienteedit, edittextdataedit, edittexthoraedit, edittextlocaledit, edittextdescedit;
    LinearLayout linearvoltaraagendaedit, btnendclienteedit, linearselecionaroutroclienteedit;
    LottieAnimationView setinhaanimadaedit;
    Dialog listapopup;
    String cpfrecebidodaagenda;
    DtoClientes clientes;
    ArrayList<DtoClientes> arrayListclientes;
    int idagendaasereditada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicao_agenda);
        linearvoltaraagendaedit = findViewById(R.id.linearvoltaraagendaedit);
        setinhaanimadaedit = findViewById(R.id.setinhaanimadaedit);
        edittextclienteedit = findViewById(R.id.edittextclienteedit);
        edittextcnpjclienteedit = findViewById(R.id.edittextcnpjclienteedit);
        edittextdataedit = findViewById(R.id.edittextdataedit);
        edittexthoraedit = findViewById(R.id.edittexthoraedit);
        edittextlocaledit = findViewById(R.id.edittextlocaledit);
        edittextdescedit = findViewById(R.id.edittextdescedit);
        btnendclienteedit = findViewById(R.id.btnendclienteedit);
        linearselecionaroutroclienteedit = findViewById(R.id.linearselecionaroutroclienteedit);
        listapopup = new Dialog(this);

        //  Get some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        idagendaasereditada = bundle.getInt("idagendaasereditada");
        cpfrecebidodaagenda = bundle.getString("cpfusu");

        DaoAgenda daoAgenda = new DaoAgenda(EdicaoAgendaActivity.this);
        DtoAgenda dtoAgenda = daoAgenda.consultaragendamentoporid(idagendaasereditada);
        edittextclienteedit.setText(dtoAgenda.getNomecliente());
        edittextcnpjclienteedit.setText(dtoAgenda.getCnpjcliente());
        edittextdataedit.setText(dtoAgenda.getDataagendamento());
        edittexthoraedit.setText(dtoAgenda.getHoraagendamento());
        edittextlocaledit.setText(dtoAgenda.getLocaldoagendamento());
        edittextdescedit.setText(dtoAgenda.getDescricaoagendamento());

        edittextlocaledit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (edittextlocaledit.getText() == null || edittextlocaledit.getText().length() == 0){
                    btnendclienteedit.setVisibility(View.VISIBLE);
                }else{
                    btnendclienteedit.setVisibility(View.GONE);
                }
            }
        });

        linearselecionaroutroclienteedit.setOnClickListener(v -> {
            abrirlistadeclientes();
        });

        btnendclienteedit.setOnClickListener(v -> {
            edittextlocaledit.setText(dtoAgenda.getLocaldoagendamento());
            btnendclienteedit.setVisibility(View.GONE);
        });


        //  When click in this Linear you will be back to Agenda
        linearvoltaraagendaedit.setOnClickListener(v -> {
            setinhaanimadaedit.playAnimation();
            new Handler().postDelayed(() -> {
                Intent voltaraagenda = new Intent(EdicaoAgendaActivity.this,AgendaActivity.class);
                voltaraagenda.putExtra("cpfusu",cpfrecebidodaagenda);
                startActivity(voltaraagenda);
                finish();
            },700);
        });
    }

    @Override
    public void onBackPressed() {
        Intent voltaraagenda = new Intent(EdicaoAgendaActivity.this,AgendaActivity.class);
        voltaraagenda.putExtra("cpfusu",cpfrecebidodaagenda);
        startActivity(voltaraagenda);
        finish();
    }

    public void abrirlistadeclientes() {
        LinearLayout btncloselista;
        ListView listaviewclienteeditagenda;
        listapopup.setContentView(R.layout.popuplistadecliente);
        btncloselista = listapopup.findViewById(R.id.btncloselista);
        listaviewclienteeditagenda = listapopup.findViewById(R.id.listaviewclienteeditagenda);

        DaoClientes daoClientes = new DaoClientes(EdicaoAgendaActivity.this);
        arrayListclientes = daoClientes.consultarTodos();
        ArrayAdapter adapter = new ArrayAdapter(EdicaoAgendaActivity.this, android.R.layout.simple_list_item_1, arrayListclientes);
        listaviewclienteeditagenda.setAdapter(adapter);

        listaviewclienteeditagenda.setOnItemClickListener((parent, view, position, id) -> {
            clientes =  arrayListclientes.get(position);
            edittextclienteedit.setText(clientes.getNomecliente());
            edittextcnpjclienteedit.setText(clientes.getCnpjcliente());
            listapopup.dismiss();
        });

        btncloselista.setOnClickListener(v -> listapopup.dismiss());

        listapopup.show();
    }
}