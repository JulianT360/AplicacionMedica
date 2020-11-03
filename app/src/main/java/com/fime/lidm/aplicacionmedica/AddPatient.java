package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AddPatient extends AppCompatActivity {

    private Button btnAddPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);

        btnAddPatient = findViewById(R.id.btn_add_patient);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Accion para guardar un registro en bd
        btnAddPatient.setOnClickListener(view -> {

        });
    }
}