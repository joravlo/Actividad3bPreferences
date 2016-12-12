package com.example.jorav.actividad3bpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    TextView tvNombre, tvDNI, tvNacimiento, tvSexo;
    public static final String PREFS = "myPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDNI = (TextView) findViewById(R.id.tvDNI);
        tvNacimiento = (TextView) findViewById(R.id.tvNacimiento);
        tvSexo = (TextView) findViewById(R.id.tvSexo);

        SharedPreferences sharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);

        tvNombre.setText(sharedPreferences.getString("nombre",""));
        tvDNI.setText(sharedPreferences.getString("DNI",""));
        tvNacimiento.setText(sharedPreferences.getString("nacimiento",""));
        if (sharedPreferences.getBoolean("sexo",false) == true){
            tvSexo.setText("Hombre");
        }else {
            tvSexo.setText("Mujer");
        }
    }
}
