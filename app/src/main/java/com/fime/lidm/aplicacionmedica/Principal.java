package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Principal extends AppCompatActivity {

    private Button btnRecipes;
    private Button btnPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Se declaran los botones
        btnPatients = findViewById(R.id.btn_patients);
        btnRecipes = findViewById(R.id.btn_recipes);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Boton para ver pacientes
        btnPatients.setOnClickListener(view -> {
            Intent intent = new Intent(Principal.this, Patients.class);
            startActivity(intent);
        });

        //Boton para ver recetas
        btnRecipes.setOnClickListener(view -> {
            Intent intent = new Intent(Principal.this, Recipes.class);
            startActivity(intent);
        });
    }
}