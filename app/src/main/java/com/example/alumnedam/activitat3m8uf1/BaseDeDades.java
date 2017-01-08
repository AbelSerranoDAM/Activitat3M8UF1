package com.example.alumnedam.activitat3m8uf1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class BaseDeDades extends SQLiteOpenHelper {
    String[] sentenciasTablas = {"CREATE TABLE Horario (grupo VARCHAR2(2), id_horario INTEGER, cod_modulo VARCHAR2(2), horario_inicio VARCHAR(20), " +
            "horario_fin VARCHAR2(20), dia_semana INTEGER)", "CREATE TABLE Profesor (id_profesor INTEGER, nombre VARCHAR2(40))",
            "CREATE TABLE Modulos (id_modulo INTEGER, cod_modulo VARCHAR2(2), id_profesor INTEGER)"};


    public BaseDeDades(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        if (db != null) {
            //Creamos tablas
            for (int i = 0; i < sentenciasTablas.length; i++) {
                db.execSQL(sentenciasTablas[i]);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
