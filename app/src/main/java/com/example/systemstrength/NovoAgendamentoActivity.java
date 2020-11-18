package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.example.systemstrength.Classes.Clientes.DaoClientes;
import com.example.systemstrength.Classes.Clientes.DtoClientes;

public class NovoAgendamentoActivity extends AppCompatActivity {
    LinearLayout linearvoltaraagenda, linearselecionaroutrocliente;
    LottieAnimationView animacaovoltaraagenda;
    CardView cardviewbtnescolhercliente;
    EditText edittextclientenovoagendamento, edittextcnpjclientenovoagendamento, edittextdatanovoagendamento, edittexthoranovoagendamento, edittextlocalnovoagendamento, edittextdescnovoagendamento;
    String cpfrecebidodaagenda;
    String clienteescolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_agendamento);
        linearvoltaraagenda = findViewById(R.id.linearvoltaraagenda);
        linearselecionaroutrocliente = findViewById(R.id.linearselecionaroutrocliente);
        animacaovoltaraagenda = findViewById(R.id.animacaovoltaraagenda);
        cardviewbtnescolhercliente = findViewById(R.id.cardviewbtnescolhercliente);
        edittextclientenovoagendamento = findViewById(R.id.edittextclientenovoagendamento);
        edittextcnpjclientenovoagendamento = findViewById(R.id.edittextcnpjclientenovoagendamento);
        edittextdatanovoagendamento = findViewById(R.id.edittextdatanovoagendamento);
        edittexthoranovoagendamento = findViewById(R.id.edittexthoranovoagendamento);
        edittextlocalnovoagendamento = findViewById(R.id.edittextlocalnovoagendamento);
        edittextdescnovoagendamento = findViewById(R.id.edittextdescnovoagendamento);

        edittextcnpjclientenovoagendamento.addTextChangedListener(MaskEditUtil.mask(edittextcnpjclientenovoagendamento, MaskEditUtil.FORMAT_CNPJ));
        edittextdatanovoagendamento.addTextChangedListener(MaskEditUtil.mask(edittextdatanovoagendamento, MaskEditUtil.FORMAT_DATE));
        edittexthoranovoagendamento.addTextChangedListener(MaskEditUtil.mask(edittexthoranovoagendamento, MaskEditUtil.FORMAT_HOUR));

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidodaagenda = bundle.getString("cpfusu");
        if (bundle.getString("cnjdaempresa") == null){
            clienteescolhido = null;
        }else{
            clienteescolhido = bundle.getString("cnjdaempresa");
        }

        validacaoerecebimentodadoscliente();

        cardviewbtnescolhercliente.setOnClickListener(v -> {
            Intent irparalistadeclientes = new Intent(NovoAgendamentoActivity.this,ListadeClientesActivity.class);
            irparalistadeclientes.putExtra("cpfusu",cpfrecebidodaagenda);
            startActivity(irparalistadeclientes);
            finish();
        });

        linearvoltaraagenda.setOnClickListener(v -> {
            animacaovoltaraagenda.playAnimation();
            new Handler().postDelayed(() -> {
                Intent voltaraosclientes = new Intent(NovoAgendamentoActivity.this,AgendaActivity.class);
                voltaraosclientes.putExtra("cpfusu",cpfrecebidodaagenda);
                startActivity(voltaraosclientes);
                finish();
            },900);
        });
    }

    private void validacaoerecebimentodadoscliente() {
        if (clienteescolhido == null){
            cardviewbtnescolhercliente.setVisibility(View.VISIBLE);
        }else{
            cardviewbtnescolhercliente.setVisibility(View.GONE);
            DaoClientes daoClientes = new DaoClientes(NovoAgendamentoActivity.this);
            DtoClientes dtoClientes = daoClientes.consultarcliente(clienteescolhido);
            edittextclientenovoagendamento.setText(dtoClientes.getNomecliente());
            edittextcnpjclientenovoagendamento.setText(dtoClientes.getCnpjcliente());
        }
    }

    @Override
    public void onBackPressed() {
        Intent voltaraosclientes = new Intent(NovoAgendamentoActivity.this,AgendaActivity.class);
        voltaraosclientes.putExtra("cpfusu",cpfrecebidodaagenda);
        startActivity(voltaraosclientes);
        finish();
    }
}