package com.example.systemstrength.Classes.Agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.systemstrength.Classes.Clientes.DtoClientes;

import java.util.ArrayList;

public class DaoAgenda extends SQLiteOpenHelper {
    private final String TABELA = "TB_AGENDA";


    public DaoAgenda(@Nullable Context context) {
        super(context, "DB_AGENDA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //  Create Data Base for Schedule's Activity
        String comando = "CREATE TABLE " + TABELA + "(" +
                "ID INTEGER PRIMARY KEY," +
                "NOMECLIENTE VARCHAR(50) NOT NULL," +
                "CNPJCLIENTE CHAR(18) NOT NULL," +
                "DATAAGENDAMENTO CHAR(10) NOT NULL," +
                "HORAAGENDAMENTO CHAR(5) NOT NULL," +
                "LOCALAGENDAMENTO VARCHAR(100) NOT NULL," +
                "DESCRICAOAGENDAMENTO VARCHAR(200) NOT NULL)";

        db.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long cadastrar(DtoAgenda agenda){
        ContentValues values = new ContentValues();
        values.put("NOMECLIENTE", agenda.getNomecliente());
        values.put("CNPJCLIENTE", agenda.getCnpjcliente());
        values.put("DATAAGENDAMENTO", agenda.getDataagendamento());
        values.put("HORAAGENDAMENTO", agenda.getHoraagendamento());
        values.put("LOCALAGENDAMENTO", agenda.getLocaldoagendamento());
        values.put("DESCRICAOAGENDAMENTO", agenda.getDescricaoagendamento());

        return getWritableDatabase().insert(TABELA, null, values);
    }

    public ArrayList<DtoAgenda> consultarTodaagenda(){
        String comando = "SELECT * FROM " + TABELA;
        Cursor cursor = getWritableDatabase().rawQuery(comando, null);
        ArrayList<DtoAgenda> agenda = new ArrayList<>();

        while (cursor.moveToNext()){
            DtoAgenda dtoAgenda = new DtoAgenda();
            dtoAgenda.setId(cursor.getInt(0));
            dtoAgenda.setNomecliente(cursor.getString(1));
            dtoAgenda.setCnpjcliente(cursor.getString(2));
            dtoAgenda.setDataagendamento(cursor.getString(3));
            dtoAgenda.setHoraagendamento(cursor.getString(4));
            dtoAgenda.setLocaldoagendamento(cursor.getString(5));
            dtoAgenda.setDescricaoagendamento(cursor.getString(6));

            agenda.add(dtoAgenda);
        }
        return  agenda;
    }

    public  int excluir(DtoAgenda agenda){
        String id = "id=?";
        String[] args  = {agenda.getId()+""};
        return  getWritableDatabase().delete(TABELA,id,args);
    }
}
