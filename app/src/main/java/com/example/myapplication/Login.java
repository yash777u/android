package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.android.gms.tasks.Task;

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();


        Button loginButton = findViewById(R.id.login_login);
        EditText emailEditText = findViewById(R.id.email_login);
        EditText pass_login = findViewById(R.id.pass_login);
        Integer count=0;
        TextView warningTextView = findViewById(R.id.warning);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String pass = pass_login.getText().toString();


                checkIfUserExists(email,pass);
                if(email.isEmpty() || pass.isEmpty()) {
                    warningTextView.setText("Error - Fill All Details!");
                }

                else
                {
                    warningTextView.setText("Congratulations !!!!");
                }
            }

            public void checkIfUserExists(String email, String password) {
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Login.this,"Firebase Login Sucessfull",Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, check if it's due to invalid user or invalid password
                                    if (task.getException() instanceof FirebaseAuthInvalidUserException) {
                                        Toast.makeText(Login.this,"User Do not Exist in Firebase",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(Login.this,"Firebase INcorrect Password",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });
            }

        });
    }
}
