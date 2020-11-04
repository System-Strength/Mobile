package com.example.systemstrength;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 **/

public class DaoLogins extends SQLiteOpenHelper {
    private final String TABELA = "TB_LOGIN";

    public DaoLogins(@Nullable Context context) {
        super(context, "DB_LOGIN", null, 1);
    }


    //  Create Data Base for Login'sActivity
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

    //  Method create new account in database
    public long cadastrar(DtoLogins usuario){
        ContentValues values = new ContentValues();
        values.put("NOMEUSU", usuario.getNomeusu());
        values.put("EMAILUSU", usuario.getEmailusu());
        values.put("TELEFONEUSU", usuario.getTelefoneusu());
        values.put("SENHAUSU", usuario.getSenhausu());

        return getWritableDatabase().insert(TABELA, null, values);
    }

    //  Method login in database
    public  long logar(DtoLogins usuarios){
        return 0;

    }
}

/*
 *  Copyright (c) 2020 System Strength
 *  Official repository https://github.com/System-Strength/Mobile
 *  Responsible developer: https://github.com/Kauavitorio
 */
