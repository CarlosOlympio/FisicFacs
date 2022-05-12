package com.example.fisicfacs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TelaSobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_sobre);

        /* Botão para voltar para a tela inicial */
        Button voltarButtonSobre = findViewById(R.id.voltarButtonSobre);
        voltarButtonSobre.setOnClickListener(view -> {
            Intent it = new Intent(TelaSobre.this, MainActivity.class);
            startActivity(it);
        });
    }
}