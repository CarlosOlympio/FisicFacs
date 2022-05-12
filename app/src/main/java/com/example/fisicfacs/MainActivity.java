package com.example.fisicfacs;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Botão para ir para "Perfil" */
        ImageButton botaoLogin = findViewById(R.id.loginButton);
        botaoLogin.setOnClickListener(view -> {
            Intent it = new Intent(MainActivity.this, TelaLogin.class);
            startActivity(it);

        });

        /* Botão para ir para "Sobre" */
        ImageButton sobreButton = findViewById(R.id.sobreButton);
        sobreButton.setOnClickListener(view -> {
            Intent itsobre = new Intent(MainActivity.this, TelaSobre.class);
            startActivity(itsobre);
        });

        /* Botão para ir para "Configurações" */
        Button configButton = findViewById(R.id.configButton);
        configButton.setOnClickListener(view -> {
           Intent itconfig = new Intent(MainActivity.this, TelaConfig.class);
           startActivity(itconfig);
        });


        }
}