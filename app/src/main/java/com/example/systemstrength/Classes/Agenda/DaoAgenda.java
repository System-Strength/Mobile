package com.example.systemstrength.Classes.Agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
