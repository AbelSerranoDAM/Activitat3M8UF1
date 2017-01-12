package com.example.alumnedam.activitat3m8uf1;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class Config extends AppCompatActivity implements View.OnClickListener {
    EditText editTextNombre;
    RadioButton radioButtonA1, radioButtonA2;
    Spinner spinnerColor, spinnerLetras;
    Button buttonGuardar;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        editTextNombre = (EditText) findViewById(R.id.editTextNombre);
        radioButtonA1 = (RadioButton) findViewById(R.id.radioButtonA1);
        radioButtonA2 = (RadioButton) findViewById(R.id.radioButtonA2);
        spinnerColor = (Spinner) findViewById(R.id.spinnerColor);
        spinnerLetras = (Spinner) findViewById(R.id.spinnerLetras);
        buttonGuardar = (Button) findViewById(R.id.buttonGuardar);
        buttonGuardar.setOnClickListener(this);
        cargarPreferencias(prefs);
    }

    public void cargarPreferencias(SharedPreferences prefs) {
        editTextNombre.setText(prefs.getString("Nom", ""));
        radioButtonA1.setChecked(prefs.getBoolean("A1", false));
        radioButtonA2.setChecked(prefs.getBoolean("A2", false));
        spinnerColor.setSelection(prefs.getInt("Color", 0));
        spinnerLetras.setSelection(prefs.getInt("Letra", 0));
    }

    public void guardarPreferencias(SharedPreferences prefs) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("Nom", editTextNombre.getText().toString());
        if (radioButtonA1.isChecked()) {
            editor.putBoolean("A1", true);
        } else if (radioButtonA2.isChecked()) {
            editor.putBoolean("A2", true);
        }
        editor.putInt("Color", spinnerColor.getSelectedItemPosition());
        editor.putInt("Letra", spinnerLetras.getSelectedItemPosition());
        editor.commit();
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        if (v.getId() == R.id.buttonGuardar) {
            i.putExtra("Nombre", editTextNombre.getText().toString());
            i.putExtra("A1", radioButtonA1.isChecked());
            i.putExtra("A2", radioButtonA2.isChecked());
            i.putExtra("Color", spinnerColor.getSelectedItemPosition());
            i.putExtra("Letra", spinnerLetras.getSelectedItemPosition());
            guardarPreferencias(prefs);
            Vibrator vib = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);
            vib.vibrate(3000);
            startActivity(i);
            finish();
        }
    }
}
