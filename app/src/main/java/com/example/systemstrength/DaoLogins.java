package com.example.systemstrength;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DaoLogins extends SQLiteOpenHelper {
    private final String TABELA = "TB_LOGIN";

    public DaoLogins(@Nullable Context context) {
        super(context, "DB_LOGIN", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "CREATE TABLE " + TABELA + "(" +
                "ID INTEGER PRIMARY KEY," +
                "NOMEUSU VARCHAR(100) NOT NULL," +
                "EMAILUSU VARCHAR(50)," +
                "TELEFONEUSU VARCHAR(15)," +
                "SENHAUSU VARCHAR(50))";

        db.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long cadastrar(DtoLogins usuario){
        ContentValues values = new ContentValues();
        values.put("NOMEUSU", usuario.getNomeusu());
        values.put("EMAILUSU", usuario.getEmailusu());
        values.put("TELEFONEUSU", usuario.getTelefoneusu());
        values.put("SENHAUSU", usuario.getSenhausu());

        return getWritableDatabase().insert(TABELA, null, values);
    }

    public  long logar(DtoLogins usuarios){
        return 0;

    }
}
