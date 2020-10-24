package com.fime.lidm.aplicacionmedica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Button;

import com.fime.lidm.aplicacionmedica.domain.entity.Usuario;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Activity para el registro de usuarios
 * @author Julian Tovar
 * @since 2020-10-24
 *
 */
public class Register extends AppCompatActivity {

    private final String TAG = "Register";
    private FirebaseAuth mAuth;

    private View backBtn;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        backBtn = findViewById(R.id.img_backButton);
        btnRegister = (Button) findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(view -> {
            validarDatosNuevoUsuario();
        });

        backBtn.setOnClickListener(view -> finish());
    }

    /**
     * Funcion para crear un usuario en el servidor de firebase.
     *
     * @param usuario Datos del usuario.
     */
    private void crearNuevoUsuario(Usuario usuario) {
        mAuth.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(Register.this, "Usuario creado correctamente. Ya puedes iniciar sesion",
                                    Toast.LENGTH_LONG).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(Register.this, Login.class);
                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    /**
     * Funcion para validar los datos para crear un nuevo usuario.
     *
     */
    private void validarDatosNuevoUsuario() {
        TextView fieldName = (TextView) findViewById(R.id.txt_name);
        TextView fieldLastName = (TextView) findViewById(R.id.txt_lastname);
        TextView fieldBirthdate = (TextView) findViewById(R.id.txt_birthdate);
        TextView fieldEmail = (TextView) findViewById(R.id.txt_email);
        TextView fieldPassword = (TextView) findViewById(R.id.txt_password_register);
        TextView fieldConfirmPassword = (TextView) findViewById(R.id.txt_confirm_password_register);

        Boolean isValid = true;
        if(Strings.isEmptyOrWhitespace(fieldName.getText().toString())) {
            fieldName.setError("Favor de ingresar un nombre.");
            isValid = false;
        }

        if(Strings.isEmptyOrWhitespace(fieldLastName.getText().toString())) {
            fieldLastName.setError("Favor de ingresar un apellido.");
            isValid = false;
        }

        if(Strings.isEmptyOrWhitespace(fieldBirthdate.getText().toString())) {
            fieldBirthdate.setError("Ingrese una fecha de nacimiento.");
            isValid = false;
        }

        if(Strings.isEmptyOrWhitespace(fieldEmail.getText().toString())) {
            fieldEmail.setError("Favor de ingresar un correo electronico.");
            isValid = false;
        }

        if(Strings.isEmptyOrWhitespace(fieldPassword.getText().toString())) {
            fieldPassword.setError("Favor de ingresar una contrasena.");
            isValid = false;
        }

        if(Strings.isEmptyOrWhitespace(fieldConfirmPassword.getText().toString())) {
            fieldConfirmPassword.setError("Favor de confirmar la contrasena.");
            isValid = false;
        }

        if((!Strings.isEmptyOrWhitespace(fieldPassword.getText().toString())
                && !Strings.isEmptyOrWhitespace(fieldConfirmPassword.getText().toString()))
                && !fieldPassword.getText().toString().equals(fieldConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Las contrasenas no coinciden.", Toast.LENGTH_SHORT).show();
            isValid = false;
            return;
        }

        if(!isValid) {
            Toast.makeText(this, "Datos no validos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = new Usuario(fieldName.getText().toString(),
                fieldLastName.getText().toString(), fieldEmail.getText().toString(),
                fieldPassword.getText().toString());

        crearNuevoUsuario(usuario);
    }
}