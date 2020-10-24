package com.fime.lidm.aplicacionmedica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fime.lidm.aplicacionmedica.domain.entity.Usuario;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Activity de login.
 *
 * @author Julian Tovar
 * @since 2020-10-24
 */
public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private final String TAG = "Login";

    private ImageView backButton;
    private View linkRegister;
    private View linkRecoverPass;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        backButton = findViewById(R.id.img_backButton); // Back Button
        btnLogin = (Button) findViewById(R.id.btn_login); // Inicio de sesion
        linkRegister = findViewById(R.id.txt_btn_register); //Vinculo de registro
        linkRecoverPass = findViewById(R.id.btn_pass_recover); //Vinculo recuperacion contrasena
    }

    @Override
    protected void onStart() {
        super.onStart();

        backButton.setOnClickListener(view -> finish());

        linkRegister.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });

        linkRecoverPass.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, RecoverPassword.class);
            startActivity(intent);
        });

        btnLogin.setOnClickListener(v -> {
            validarDatosInicioSesion();
        });
    }


    /**
     * Funcion para iniciar sesion en la aplicacion.
     *
     * @param usuario Datos del usuario.
     */
    private void inicioSesion(Usuario usuario) {
        mAuth.signInWithEmailAndPassword(usuario.getEmail(), usuario.getPassword())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Login.this, "Autenticacion exitosa.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(Login.this, "Error al iniciar sesion.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    /**
     * Funcion para validar las credenciales del usuario.
     *
     */
    private void validarDatosInicioSesion() {
        TextView fieldEmail = (TextView) findViewById(R.id.txt_email);
        TextView fieldPassword = (TextView) findViewById(R.id.txt_password);

        Boolean isValid = true;

        if(Strings.isEmptyOrWhitespace(fieldEmail.getText().toString())) {
            fieldEmail.setError("Favor de ingresar un correo electronico.");
            isValid = false;
        }

        if(Strings.isEmptyOrWhitespace(fieldPassword.getText().toString())) {
            fieldPassword.setError("Favor de ingresar una contrasena.");
            isValid = false;
        }

        if(!isValid) {
            Toast.makeText(this, "Datos no validos.", Toast.LENGTH_SHORT).show();
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(fieldEmail.getText().toString());
        usuario.setPassword(fieldPassword.getText().toString());
        inicioSesion(usuario);
    }
}