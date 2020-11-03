package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fime.lidm.aplicacionmedica.domain.entity.Patient;

public class PatientDetails extends AppCompatActivity {

    Patient patientActual;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        Intent intent = getIntent();
        patientActual = (Patient) intent.getSerializableExtra("patient");
        header = findViewById(R.id.txt_name_patient);

        // Se setea nombre en el header
        header.setText(patientActual.getAllName());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}