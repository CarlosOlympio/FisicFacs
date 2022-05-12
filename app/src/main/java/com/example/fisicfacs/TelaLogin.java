package com.example.fisicfacs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLogin extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        /* Criando conteúdo do Spinner sexo */
        String [] sexoSpinner = {"Masc.","Fem."};

         /* Get shared Preference */
        SharedPreferences prefslogin = getSharedPreferences("preferencias", MODE_PRIVATE);
        String nomeSave = prefslogin.getString("nome", "notDefined");
        String pesoSave = prefslogin.getString("peso", "notDefined");
        String alturaSave = prefslogin.getString("altura", "notDefined");
        String dataSave = prefslogin.getString("data", "notDefined");
        String sexoSave = prefslogin.getString("sexo", "notDefined");

        /* SharedPreference */
        EditText nome = findViewById(R.id.nomeBox);
        Spinner sexo = findViewById(R.id.telalogin_spinner);
        EditText peso = findViewById(R.id.pesoBox);
        EditText altura = findViewById(R.id.alturaBox);
        EditText data = findViewById(R.id.dataBox);



        /* Spinner "sexo" e if´s pro shared preference */
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<>(this, R.layout.spinner_pers,sexoSpinner);
        adapterSexo.setDropDownViewResource(R.layout.spinner_pers);
        sexo.setAdapter(adapterSexo);

        if (!sexoSave.equals("notDefined")) {
            int spinnerPosition = adapterSexo.getPosition(sexoSave);
            sexo.setSelection(spinnerPosition);
        }

        if(!nomeSave.equals("notdefined")){
            nome.setText(nomeSave);
        }

        if(!pesoSave.equals("notdefined")){
            peso.setText(pesoSave);
        }

        if(!alturaSave.equals("notdefined")){
            altura.setText(alturaSave);
        }

        if(!dataSave.equals("notdefined")){
            data.setText(dataSave);
        }


        /* Botão Salvar */
        Button salvar = findViewById(R.id.salvarButtonPerfil);
        salvar.setOnClickListener((View View) -> {
            SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = prefs.edit();

            /* Put do Shared Preference */
            ed.putString("nome", nome.getText().toString());
            ed.putString("peso", peso.getText().toString());
            ed.putString("altura", altura.getText().toString());
            ed.putString("data", data.getText().toString());
            ed.putString("sexo", sexo.getSelectedItem().toString());

            ed.apply();
            Toast.makeText(getBaseContext(), "Dados Salvos", Toast.LENGTH_LONG).show();

        });

        /* Botão para voltar para a tela inicial */
        Button voltarButton = findViewById(R.id.voltarButtonPerfil);
        voltarButton.setOnClickListener(view -> {
            Intent it = new Intent(TelaLogin.this, MainActivity.class);
            startActivity(it);
        });
    }
}
