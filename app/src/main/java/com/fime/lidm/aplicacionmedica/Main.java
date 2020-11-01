package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity Main
 *
 * @author Julian Tovar
 * @since 2020-10-24
 *
 */
public class Main extends AppCompatActivity {

    private Button btnIngresar;
    private TextView linkRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIngresar = (Button) findViewById(R.id.btn_ingresar); //Pantalla Login
        linkRegister = findViewById(R.id.link_register_main); // Pantalla Registro
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnIngresar.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, Login.class);
            startActivity(intent);
        });

        linkRegister.setOnClickListener(view -> {
            Intent intent = new Intent(Main.this, Register.class);
            startActivity(intent);
        });
    }
}