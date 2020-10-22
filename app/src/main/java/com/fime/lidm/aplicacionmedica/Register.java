package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    View backBtn;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backBtn = findViewById(R.id.img_backButton);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(view -> {
            Intent intent = new Intent(Register.this, Login.class);
            startActivity(intent);
        });

        backBtn.setOnClickListener(view -> finish());
    }
}