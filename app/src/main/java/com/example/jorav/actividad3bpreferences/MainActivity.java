package com.example.jorav.actividad3bpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Button btEnviar;
    EditText etNombre, etDNI, etNacimiento;
    RadioButton rbHombre, rbMujer;
    public static final String PREFS = "myPreferences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEnviar = (Button) findViewById(R.id.btEnviar);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etDNI = (EditText) findViewById(R.id.etDNI);
        etNacimiento = (EditText) findViewById(R.id.etNacimiento);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nombre",etNombre.getText().toString());
                editor.putString("DNI",etDNI.getText().toString());
                editor.putString("nacimiento",etNacimiento.getText().toString());
                if (rbHombre.isChecked()){
                    editor.putBoolean("sexo",true);
                }else {
                    editor.putBoolean("sexo",false);
                }
                editor.commit();
                Intent intent = new Intent(MainActivity.this,Resumen.class);
                startActivity(intent);
            }
        });
    }
}
