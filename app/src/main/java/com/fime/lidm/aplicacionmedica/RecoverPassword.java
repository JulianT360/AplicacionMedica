package com.fime.lidm.aplicacionmedica;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fime.lidm.aplicacionmedica.domain.entity.Usuario;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Activity RecoverPassword
 *
 * @author Julian Tovar
 * @since 2020-10-24
 *
 */
public class RecoverPassword extends AppCompatActivity {

    private final String TAG = "RecoverPassword";
    private FirebaseAuth mAuth;

    private ImageView btnBack;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);
        mAuth = FirebaseAuth.getInstance();

        btnBack = (ImageView) findViewById(R.id.img_backButton);
        btnEnviar = (Button) findViewById(R.id.btn_send_pass);
    }

    @Override
    protected void onStart() {
        super.onStart();

        btnBack.setOnClickListener(v -> finish());

        btnEnviar.setOnClickListener(v -> {
            validaRestauracionContrasena();
        });
    }

    /**
     * Funcion para validar los datos para recuperacion de contrasena.
     *
     */
    private void validaRestauracionContrasena() {
        TextView fieldEmail = (TextView) findViewById(R.id.txt_email);

        Boolean isValid = true;

        if(Strings.isEmptyOrWhitespace(fieldEmail.getText().toString())) {
            fieldEmail.setError("Favor de ingresar un correo electronico.");
            isValid = false;
        }

        if(!isValid) {
            Toast.makeText(this, "Datos no validos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(fieldEmail.getText().toString());
        restauracionContrasena(usuario);
    }

    /**
     * Envia correo de recuperacion de contrasena
     *
     * @param usuario Datos del usuario.
     */
    private void restauracionContrasena(Usuario usuario) {
        mAuth.sendPasswordResetEmail(usuario.getEmail())
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()) {
                        Log.d(TAG, "createUserWithEmail:success");
                        Intent intent = new Intent(RecoverPassword.this,
                                RecoverPasswordSuccess.class);
                        startActivity(intent);
                    } else {
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RecoverPassword.this, "Ocurrio un error al restaurar la contrasena.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }
}