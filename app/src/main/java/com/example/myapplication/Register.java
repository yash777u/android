package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();

        EditText userName = findViewById(R.id.fullname_signup);
        EditText Password = findViewById(R.id.pass_signup);
        EditText email = findViewById(R.id.email_signup);
        EditText retype = findViewById(R.id.retype_pass);
        TextView signup_warn = findViewById(R.id.singup_warning);
        Button signUp = findViewById(R.id.signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String pass = Password.getText().toString();
                String Email = email.getText().toString();
                String retype_pass = retype.getText().toString();


                if(username.isEmpty() || pass.isEmpty()|| Email.isEmpty()|| retype_pass.isEmpty())
                {
                    signup_warn.setText("No field should be left empty !!");
                }

                else
                {
                    auth.createUserWithEmailAndPassword(Email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful())
                          {
                              Toast.makeText(Register.this, "SignUp Successful", Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(Register.this, Login.class));
                          }

                          else {
                              Toast.makeText(Register.this, "Signup Unsuccessful"+ task.getException(), Toast.LENGTH_SHORT).show();
                          }
                        }
                    });

                }



            }
        });
    }

    public void setAuth(FirebaseAuth auth) {
        this.auth = auth;
    }
}