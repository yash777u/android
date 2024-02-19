package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

                if(email.isEmpty() || pass.isEmpty()) {
                    warningTextView.setText("Error - Fill All Details!!");
                }

                else
                {
                    warningTextView.setText("Congratulations !!!!");
                }
            }
        });
    }
}
