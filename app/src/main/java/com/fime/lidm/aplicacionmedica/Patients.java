package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fime.lidm.aplicacionmedica.domain.entity.Patient;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Patients extends AppCompatActivity {

    private final String TAG = "Patients";

    private DatabaseReference mPatientReference;
    private ValueEventListener mPatientListener;

    private List<Patient> lstPatients;
    private ListView lstPatientsView;
    private ListViewAdapter adapter;
    private Button btnAddPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients);

        //Declarations
        lstPatients = new ArrayList<>();
        lstPatientsView = findViewById(R.id.lst_patients);
        btnAddPatient = findViewById(R.id.btn_add_patient);

        //Se genera instancia de base de datos
        mPatientReference = FirebaseDatabase.getInstance().getReference().child("pacientes");

        //Obtiene la lista de pacientes
        if(lstPatients.isEmpty()) {
            getPatients();
        } else {
            createListView();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        lstPatientsView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent intent = new Intent(Patients.this, PatientDetails.class);
            intent.putExtra("patient", lstPatients.get(i));
            startActivity(intent);
        });

        // Boton para agregar pacientes
        btnAddPatient.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddPatient.class);
            startActivity(intent);
        });
    }

    private void getPatients() {
        mPatientListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                lstPatients = new ArrayList<>();
                for(DataSnapshot patientSnapshot : snapshot.getChildren()) {
                    Patient patientItem = new Patient();
                    patientItem.setName(patientSnapshot.child("name").getValue().toString());
                    patientItem.setLastname(patientSnapshot.child("lastname").getValue().toString());
                    patientItem.setAge(Integer.parseInt(patientSnapshot.child("age").getValue().toString()));
                    patientItem.setWeight(patientSnapshot.child("weight").getValue().toString());
                    patientItem.setHeight(patientSnapshot.child("height").getValue().toString());
                    patientItem.setGenre(patientSnapshot.child("genre").getValue().toString());
                    lstPatients.add(patientItem);
                }

                createListView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w(TAG, "onCancelled:Error al realizar la consulta");
            }
        };

        mPatientReference.addValueEventListener(mPatientListener);
    }

    private void createListView(){
        adapter = new ListViewAdapter(this, lstPatients);
        lstPatientsView.setAdapter(adapter);
    }
}