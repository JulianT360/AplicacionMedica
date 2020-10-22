package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    ImageView backButton;
    View linkRegister;
    View btnRecoverPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        backButton = findViewById(R.id.img_backButton); // Back Button
        linkRegister = findViewById(R.id.txt_btn_register); //Vinculo de registro
        btnRecoverPass = findViewById(R.id.btn_pass_recover);

        backButton.setOnClickListener(view -> finish());

        linkRegister.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });

        btnRecoverPass.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, RecoverPassword.class);
            startActivity(intent);
        });
    }
}