package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class RecoverPassword extends AppCompatActivity {

    ImageView btnBack;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        btnBack = findViewById(R.id.img_backButton);
        btnEnviar = findViewById(R.id.btn_send_pass);

        btnBack.setOnClickListener(v -> finish());

        btnEnviar.setOnClickListener(v -> {
            Intent intent = new Intent(RecoverPassword.this, RecoverPasswordSuccess.class);
            startActivity(intent);
        });
    }
}