package com.example.alumnedam.activitat3m8uf1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int color, letra;
    private boolean a1, a2;
    private TextView textViewTitulo, textViewProfesor, textViewModulo, textViewInicio, textViewFin, textViewResProfesor, textViewResModulo,
            textViewResInicio, textViewResFin;
    private String[] sentenciasInsert = {"INSERT INTO Profesor (id_profesor, nombre) VALUES ('1','Lluis')",
            "INSERT INTO Profesor (id_profesor, nombre) VALUES ('2','Jorge')",
            "INSERT INTO Profesor (id_profesor, nombre) VALUES ('3','Josefa')",
            "INSERT INTO Profesor (id_profesor, nombre) VALUES ('4','Jose')",
            "INSERT INTO Profesor (id_profesor, nombre) VALUES ('5','Marta')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('1','M2/M5/M6','2')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('2','M3','3')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('5','M7','4')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('6','M8','1')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('7','M9','2')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('8','M10','5')",
            "INSERT INTO Modulos (id_modulo, cod_modulo, id_profesor) VALUES ('9','TUT','3')",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','1','M7','15:00:00','16:00:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','2','M7','15:00:00','16:00:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','3','M7','16:00:00','17:00:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','4','M7','16:00:00','17:00:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','5','M7','17:00:00','18:00:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','6','M7','17:00:00','18:00:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','7','TUT','18:20:00','19:20:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','8','TUT','18:20:00','19:20:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','9','M3','19:20:00','20:20:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','10','M3','20:20:00','21:20:00',01)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','11','M3','15:00:00','16:00:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','12','M8','15:00:00','16:00:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','13','M3','16:00:00','17:00:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','14','M8','16:00:00','17:00:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','15','M10','17:00:00','18:00:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','16','M10','17:00:00','18:00:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','17','M10','18:20:00','19:20:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','18','M10','18:20:00','19:20:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','19','M2/M5/M6','19:20:00','20:20:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','20','M2/M5/M6','19:20:00','20:20:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','21','M2/M5/M6','20:20:00','21:20:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','22','M2/M5/M6','20:20:00','21:20:00',02)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','23','M2/M5/M6','16:00:00','17:00:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','24','M2/M5/M6','16:00:00','17:00:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','25','M9','17:00:00','18:00:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','26','M8','17:00:00','18:00:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','27','M9','18:20:00','19:20:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','28','M8','18:20:00','19:20:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','29','M3','19:20:00','20:20:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','30','M9','19:20:00','20:20:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','31','M3','20:20:00','21:20:00',03)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','32','M9','15:00:00','16:00:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','33','M8','16:00:00','17:00:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','34','M3','16:00:00','17:00:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','35','M8','17:00:00','18:00:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','36','M3','17:00:00','18:00:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','37','M2/M5/M6','18:20:00','19:20:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','38','M2/M5/M6','18:20:00','19:20:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','39','M2/M5/M6','19:20:00','20:20:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','40','M2/M5/M6','19:20:00','20:20:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','41','M2/M5/M6','20:20:00','21:20:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','42','M2/M5/M6','20:20:00','21:20:00',04)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','43','M10','15:00:00','16:00:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','44','M10','15:00:00','16:00:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','45','M10','16:00:00','17:00:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','46','M10','16:00:00','17:00:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','47','M8','17:00:00','18:00:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','48','M9','17:00:00','18:00:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','49','M8','18:20:00','19:20:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','50','M9','18:20:00','19:20:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','51','M2/M5/M6','19:20:00','20:20:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','52','M2/M5/M6','19:20:00','20:20:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A1','53','M2/M5/M6','20:20:00','21:20:00',05)",
            "INSERT INTO Horario (grupo, id_horario, cod_modulo, horario_inicio, horario_fin,dia_semana) VALUES ('A2','54','M2/M5/M6','20:20:00','21:20:00',05)",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        BaseDeDades usdbh = new BaseDeDades(this, "DBHorarioDAM", null, 1);
        SQLiteDatabase db = usdbh.getWritableDatabase();
        anyadirDatos(db);
        Intent i = getIntent();
        textViewTitulo = (TextView) findViewById(R.id.textViewTitulo);
        textViewProfesor = (TextView) findViewById(R.id.textViewProfesor);
        textViewModulo = (TextView) findViewById(R.id.textViewModulo);
        textViewInicio = (TextView) findViewById(R.id.textViewInicio);
        textViewFin = (TextView) findViewById(R.id.textViewFin);
        textViewResProfesor = (TextView) findViewById(R.id.textViewResProfesor);
        textViewResModulo = (TextView) findViewById(R.id.textViewResModulo);
        textViewResInicio = (TextView) findViewById(R.id.textViewResInicio);
        textViewResFin = (TextView) findViewById(R.id.textViewResFin);
        color = i.getIntExtra("Color", 0);
        letra = i.getIntExtra("Letra", 0);
        a1 = i.getBooleanExtra("A1", false);
        a2 = i.getBooleanExtra("A2", false);
        consulta(db, a1, a2);
        cerrarDB(db);
        cambiarFondo(rl);
        cambiarLetra();
    }

    public void cambiarFondo(RelativeLayout rl) {
        switch (color) {
            case 0:
                rl.setBackgroundColor(Color.RED);
                break;
            case 1:
                rl.setBackgroundColor(Color.BLUE);
                break;
            case 2:
                rl.setBackgroundColor(Color.GREEN);
                break;
            case 3:
                rl.setBackgroundColor(Color.YELLOW);
                break;
        }
    }

    public void cambiarLetra() {
        switch (letra) {
            case 0:
                textViewTitulo.setTypeface(Typeface.SANS_SERIF);
                textViewProfesor.setTypeface(Typeface.SANS_SERIF);
                textViewModulo.setTypeface(Typeface.SANS_SERIF);
                textViewInicio.setTypeface(Typeface.SANS_SERIF);
                textViewFin.setTypeface(Typeface.SANS_SERIF);
                textViewResProfesor.setTypeface(Typeface.SANS_SERIF);
                textViewResModulo.setTypeface(Typeface.SANS_SERIF);
                textViewResInicio.setTypeface(Typeface.SANS_SERIF);
                textViewResFin.setTypeface(Typeface.SANS_SERIF);
                break;
            case 1:
                textViewTitulo.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewProfesor.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewModulo.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewInicio.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewFin.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewResProfesor.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewResModulo.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewResInicio.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                textViewResFin.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                break;
            case 2:
                textViewTitulo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewProfesor.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewModulo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewInicio.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewFin.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewResProfesor.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewResModulo.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewResInicio.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textViewResFin.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                break;
        }
    }

    public void anyadirDatos(SQLiteDatabase db) {
        for (int i = 0; i < sentenciasInsert.length; i++) {
            db.execSQL(sentenciasInsert[i]);
        }
    }

    public void cerrarDB(SQLiteDatabase db) {
        db.close();
    }

    public void consulta(SQLiteDatabase db, boolean a1, boolean a2) {
        String profesor, modulo, inicio, fin;
        if (a1) {
            Cursor c1 = db.rawQuery(" SELECT p.nombre, h.cod_modulo, h.horario_inicio, h.horario_fin  " +
                    "FROM profesor AS p, modulos AS m, horario AS h WHERE p.id_profesor=m.id_profesor " +
                    "AND h.cod_modulo=m.cod_modulo AND (select strftime('%H:%M:%S', datetime('now'),'+1 hour')) " +
                    "BETWEEN h.horario_inicio AND h.horario_fin AND h.dia_semana=(select strftime('%d', datetime('now'),'-1 day')) " +
                    "AND h.grupo='A1' GROUP BY p.nombre", null);
            if (c1.moveToFirst()) {
                do {
                    profesor = c1.getString(0);
                    modulo = c1.getString(1);
                    inicio = c1.getString(2);
                    fin = c1.getString(3);
                } while (c1.moveToNext());
                textViewResProfesor.setText(profesor);
                textViewResModulo.setText(modulo);
                textViewResInicio.setText(inicio);
                textViewResFin.setText(fin);
            } else {
                Toast.makeText(this, "NO HAY CLASE", Toast.LENGTH_SHORT).show();
            }
        } else if (a2) {
            Cursor c2 = db.rawQuery(" SELECT p.nombre, h.cod_modulo, h.horario_inicio, h.horario_fin  " +
                    "FROM profesor AS p, modulos AS m, horario AS h WHERE p.id_profesor=m.id_profesor " +
                    "AND h.cod_modulo=m.cod_modulo AND (select strftime('%H:%M:%S', datetime('now'),'+1 hour')) " +
                    "BETWEEN h.horario_inicio AND h.horario_fin AND h.dia_semana=(select strftime('%d', datetime('now'),'-1 day')) " +
                    "AND h.grupo='A2' GROUP BY p.nombre", null);
            if (c2.moveToFirst()) {
                do {
                    profesor = c2.getString(0);
                    modulo = c2.getString(1);
                    inicio = c2.getString(2);
                    fin = c2.getString(3);
                } while (c2.moveToNext());
                textViewResProfesor.setText(profesor);
                textViewResModulo.setText(modulo);
                textViewResInicio.setText(inicio);
                textViewResFin.setText(fin);
            } else {
                Toast.makeText(this, "NO HAY CLASE", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent i = new Intent(this, Config_ajustes.class);
        switch (menuItem.getItemId()) {
            case R.id.ajustes:
                startActivity(i);
                finish();
        }
        return true;
    }
    public void onDestroy()
    {

    }
}



