package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PatientDetails extends AppCompatActivity {

    String name;
    TextView header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        Intent intent = getIntent();
        name = intent.getStringExtra("patient");
        header = (TextView) findViewById(R.id.txt_name_patient);

        header.setText(name);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}