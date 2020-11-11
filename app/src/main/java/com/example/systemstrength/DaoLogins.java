package com.example.systemstrength;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class DaoLogins extends SQLiteOpenHelper {
    private final String TABELA = "TB_FUNCIONARIOS";

    public DaoLogins(@Nullable Context context) {
        super(context, "DB_LOGINS", null, 2);
    }


    //  Create Data Base for Login's Activity
    @Override
    public void onCreate(SQLiteDatabase db) {
        String comando = "CREATE TABLE " + TABELA + "(" +
                "ID INTEGER PRIMARY KEY," +
                "CPFFUNC VARCHAR(14) NOT NULL," +
                "NOMEFUNC VARCHAR(100) NOT NULL," +
                "EMAILFUNC VARCHAR(50) NOT NULL," +
                "ENDERECOFUNC VARCHAR(50)," +
                "TELEFONEFUNC VARCHAR(15)," +
                "CARGOFUNC VARCHAR(50) NOT NULL," +
                "ULTIMAREUNIAOFUNC VARCHAR(50)," +
                "SENHAFUNC VARCHAR(40) NOT NULL)";

        db.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //  Method create new account in database
    public long cadastrar(DtoLogins funcionario){
        ContentValues values = new ContentValues();
        values.put("CPFFUNC", funcionario.getCpffunc());
        values.put("NOMEFUNC", funcionario.getNomefunc());
        values.put("EMAILFUNC", funcionario.getEmailfunc());
        values.put("ENDERECOFUNC", funcionario.getEnderecofunc());
        values.put("TELEFONEFUNC", funcionario.getTelefonefunc());
        values.put("CARGOFUNC", funcionario.getCargofunc());
        values.put("SENHAFUNC", funcionario.getSenhafunc());

        return getWritableDatabase().insert(TABELA, null, values);
    }

    //  Method login in database
    public void logar(DtoLogins usuarios){
        String comando = "SELECT * FROM " + TABELA + " WHERE NOMEFUNC = ? and SENHAFUNC = ?  ";
        String[] args = {"%" + usuarios + "%"};
        Cursor cursor = getWritableDatabase().rawQuery(comando, args);
    }
}

/*
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 */
