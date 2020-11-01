package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity RecoverPassword
 *
 * @author Julian Tovar
 * @since 2020-10-24
 *
 */
public class RecoverPasswordSuccess extends AppCompatActivity {

    Button btnBackMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password_success);

        btnBackMain = findViewById(R.id.btn_back_main);

        btnBackMain.setOnClickListener(v -> {
            Intent intent = new Intent(RecoverPasswordSuccess.this, Main.class);
            startActivity(intent);
        });
    }
}