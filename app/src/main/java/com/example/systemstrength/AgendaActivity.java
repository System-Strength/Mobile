package com.example.systemstrength;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.systemstrength.Classes.Agenda.DaoAgenda;
import com.example.systemstrength.Classes.Agenda.DtoAgenda;

import java.util.ArrayList;

public class AgendaActivity extends AppCompatActivity {
    LinearLayout linearbtnhomeagenda;
    CardView cardviewloadingpricipalagenda, cardviewnovoagendamento, cardviewanimacaonovoagendamento, cardviewanimationdeleteagenda;
    ListView listviewagenda;
    LottieAnimationView animationdeleteagenda;
    ArrayList<DtoAgenda> arraylistagenda;
    DtoAgenda agenda;
    DaoAgenda daoAgenda = new DaoAgenda(AgendaActivity.this);
    Dialog myDialog;
    String cpfrecebidobase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        linearbtnhomeagenda = findViewById(R.id.linearbtnhomeagenda);
        cardviewloadingpricipalagenda = findViewById(R.id.cardviewloadingpricipalagenda);
        cardviewnovoagendamento = findViewById(R.id.cardviewnovoagendamento);
        cardviewanimacaonovoagendamento = findViewById(R.id.cardviewanimacaonovoagendamento);
        listviewagenda = findViewById(R.id.listviewagenda);
        cardviewanimationdeleteagenda = findViewById(R.id.cardviewanimationdeleteagenda);
        animationdeleteagenda = findViewById(R.id.animationdeleteagenda);
        myDialog = new Dialog(this);

        //  Get some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidobase = bundle.getString("cpfusu");

        DaoAgenda daoAgenda= new DaoAgenda(AgendaActivity.this);
        arraylistagenda = daoAgenda.consultarTodaagenda();
        atualizarlistview();

        listviewagenda.setOnItemLongClickListener((parent, view, position, id) -> {
            agenda = arraylistagenda.get(position);
            registerForContextMenu(listviewagenda);
            return false;
        });

        cardviewnovoagendamento.setOnClickListener(v -> {
            cardviewnovoagendamento.setVisibility(View.GONE);
            cardviewanimacaonovoagendamento.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent irparanovoagendamento = new Intent(AgendaActivity.this,NovoAgendamentoActivity.class);
                irparanovoagendamento.putExtra("cpfusu",cpfrecebidobase);
                startActivity(irparanovoagendamento);
                finish();
            },1500);
        });

        //  When click in this linear you will go to Principal Activity
        linearbtnhomeagenda.setOnClickListener(v ->{
            cardviewloadingpricipalagenda.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                Intent voltarparaprincipal = new Intent(AgendaActivity.this,PrincipalActivity.class);
                voltarparaprincipal.putExtra("cpfusu",cpfrecebidobase);
                startActivity(voltarparaprincipal);
                finish();
            },1500);
        });
    }

    //  Create method for update  ListView
    private void atualizarlistview() {
        ArrayAdapter adapter = new ArrayAdapter(AgendaActivity.this, android.R.layout.simple_list_item_1, arraylistagenda);
        listviewagenda.setAdapter(adapter);
    }

    //  Create method for delete some client of  ListView
    private void excluir() {
        AlertDialog.Builder msg = new AlertDialog.Builder(AgendaActivity.this);
        msg.setMessage("Confirma a exclusão?");
        msg.setPositiveButton("Sim", (dialogInterface, i) -> {
            int deletados = daoAgenda.excluir(agenda);
            if (deletados>0){
                cardviewanimationdeleteagenda.setVisibility(View.VISIBLE);
                animationdeleteagenda.playAnimation();
                new Handler().postDelayed(() -> {
                    Toast.makeText(AgendaActivity.this, "Excluído com sucesso!", Toast.LENGTH_SHORT).show();
                    arraylistagenda = daoAgenda.consultarTodaagenda();
                    atualizarlistview();
                    cardviewanimationdeleteagenda.setVisibility(View.GONE);
                    animationdeleteagenda.pauseAnimation();
                },2000);
            } else {
                Toast.makeText(AgendaActivity.this, "Erro ao Excluir!", Toast.LENGTH_SHORT).show();
            }
        });
        msg.setNegativeButton("Não", null);
        msg.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.setHeaderTitle("• " + agenda.getNomecliente()+ " •");
        menu.add(0,0,0,"Detalhes");
        menu.add(0,1,1,"Editar");
        menu.add(0,2,2,"Excluir");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == 0){
            aparecerpopup();
        }else if (item.getItemId()  == 1){

        }else if (item.getItemId() == 2){
            excluir();
        }

        return super.onContextItemSelected(item);
    }

    public void aparecerpopup() {
        TextView txtnomeclientedetalhes, txtcnpjclientedetalhes, txtdatadetalhes, txthourdetalhes, txtlocaldetalhes, txtdescdetalhes;
        LinearLayout btnclosedetalhes;
        myDialog.setContentView(R.layout.popupdetalhesagenda);
        txtnomeclientedetalhes = (TextView) myDialog.findViewById(R.id.txtnomeclientedetalhes);
        txtcnpjclientedetalhes = (TextView) myDialog.findViewById(R.id.txtcnpjclientedetalhes);
        txtdatadetalhes = (TextView) myDialog.findViewById(R.id.txtdatadetalhes);
        txthourdetalhes = (TextView) myDialog.findViewById(R.id.txthourdetalhes);
        txtlocaldetalhes = (TextView) myDialog.findViewById(R.id.txtlocaldetalhes);
        txtdescdetalhes = (TextView) myDialog.findViewById(R.id.txtdescdetalhes);
        btnclosedetalhes = (LinearLayout) myDialog.findViewById(R.id.btnclosedetalhes);

        txtnomeclientedetalhes.setText(agenda.getNomecliente());
        txtcnpjclientedetalhes.setText(agenda.getCnpjcliente());
        txtdatadetalhes.setText(agenda.getDataagendamento());
        txthourdetalhes.setText(agenda.getHoraagendamento());
        txtlocaldetalhes.setText(agenda.getLocaldoagendamento());
        txtdescdetalhes.setText(agenda.getDescricaoagendamento());

        btnclosedetalhes.setOnClickListener(v1 -> myDialog.dismiss());

        myDialog.show();
    }
}