package com.example.fisicfacs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TelaConfig extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_config);

        /* Criando conteúdo dos Spinner´s */
        String [] SpinnerTE = {"Caminhada","Corrida", "Bicicleta"};
        String [] SpinnerUV = {"km/h", "m/s"};
        String [] SpinnerOM = {"Nenhuma", "North Up", "Course Up"};
        String [] SpinnerTM = {"Vetorial", "Satélite"};

        /* Get Shared Preferences*/
        SharedPreferences prefsconfig = getSharedPreferences("preferencias", MODE_PRIVATE);
        String teSave = prefsconfig.getString("TE", "notDefined");
        String uvSave = prefsconfig.getString("UV", "notDefined");
        String omSave = prefsconfig.getString("OM", "notDefined");
        String tmSave = prefsconfig.getString("TM", "notDefined");


        /* Definindo os os elementos */
        Spinner TE = findViewById(R.id.spinnerTE);
        Spinner UV = findViewById(R.id.spinnerUV);
        Spinner OM = findViewById(R.id.spinnerOM);
        Spinner TM = findViewById(R.id.spinnerTM);
        Button voltarConfig = findViewById(R.id.voltarButtonConfig);
        Button salvarConfig = findViewById(R.id.salvarButtonConfig);

        /* Spinner "tipo de exercício" */
        ArrayAdapter<String> adapterTE = new ArrayAdapter<>(this, R.layout.spinner_pers,SpinnerTE);
        adapterTE.setDropDownViewResource(R.layout.spinner_pers);
        TE.setAdapter(adapterTE);

        if (!teSave.equals("notDefined")) {
            int spinnerPosition = adapterTE.getPosition(teSave);
            TE.setSelection(spinnerPosition);
        }

        /* Spinner "unidade de velocidade" */
        ArrayAdapter<String> adapterUV = new ArrayAdapter<>(this, R.layout.spinner_pers,SpinnerUV);
        adapterUV.setDropDownViewResource(R.layout.spinner_pers);
        UV.setAdapter(adapterUV);

        if (!uvSave.equals("notDefined")) {
            int spinnerPosition = adapterUV.getPosition(uvSave);
            UV.setSelection(spinnerPosition);
        }

        /* Spinner "orientação do mapa" */
        ArrayAdapter<String> adapterOM = new ArrayAdapter<>(this, R.layout.spinner_pers,SpinnerOM);
        adapterOM.setDropDownViewResource(R.layout.spinner_pers);
        OM.setAdapter(adapterOM);

        if (!omSave.equals("notDefined")) {
            int spinnerPosition = adapterOM.getPosition(omSave);
            OM.setSelection(spinnerPosition);
        }

        /* Spinner "tipo de mapa" */
        ArrayAdapter<String> adapterTM = new ArrayAdapter<>(this, R.layout.spinner_pers,SpinnerTM);
        adapterTM.setDropDownViewResource(R.layout.spinner_pers);
        TM.setAdapter(adapterTM);

        if (!tmSave.equals("notDefined")) {
            int spinnerPosition = adapterTM.getPosition(tmSave);
            TM.setSelection(spinnerPosition);
        }

        /* Botão Salvar */
        salvarConfig.setOnClickListener((View View) -> {
            SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
            SharedPreferences.Editor ed = prefs.edit();

        /* Put do Shared Preference */
            ed.putString("TE", TE.getSelectedItem().toString());
            ed.putString("UV", UV.getSelectedItem().toString());
            ed.putString("OM", OM.getSelectedItem().toString());
            ed.putString("TM", TM.getSelectedItem().toString());

            ed.apply();
            Toast.makeText(getBaseContext(), "Dados Salvos", Toast.LENGTH_LONG).show();
        });

        /* Botão para voltar para a tela inicial */
        voltarConfig.setOnClickListener(view -> {
            Intent it = new Intent(TelaConfig.this, MainActivity.class);
            startActivity(it);
        });
    }
}