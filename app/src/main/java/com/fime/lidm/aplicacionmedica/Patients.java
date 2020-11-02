package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Patients extends AppCompatActivity {

    ListView lstPatients;
    private List<String> lstNames;
    ListViewAdapter adapter;
    Button btnAddPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        lstNames = new ArrayList<>();
        lstPatients = findViewById(R.id.lst_patients);
        btnAddPatient = (Button) findViewById(R.id.btn_add_patient);

        createListView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        lstPatients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Intent intent = new Intent(Patients.this, PatientDetails.class);
                intent.putExtra("patient", lstNames.get(i));
                startActivity(intent);
            }
        });

        // Boton para agregar pacientes
        btnAddPatient.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddPatient.class);
            startActivity(intent);
        });
    }

    private void createListView(){
        lstNames.add("Julian");
        lstNames.add("Mary");
        lstNames.add("Ivan");
        lstNames.add("Mateo");
        lstNames.add("Andrea");

        adapter = new ListViewAdapter(this, lstNames);

        lstPatients.setAdapter(adapter);
    }
}