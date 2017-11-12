package com.mobile.travest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button btnRegister;
    DBHandler dbHandler;
    String name, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = (EditText) findViewById(R.id.etNameRegister);
        etEmail = (EditText) findViewById(R.id.etEmailRegister);
        etPassword = (EditText) findViewById(R.id.etPasswordRegister);
        btnRegister = (Button) findViewById(R.id.btnRegister);

        dbHandler = new DBHandler(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = etName.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                if (!name.isEmpty()) {
                    if (!email.isEmpty()) {
                        if (!password.isEmpty()) {
                            dbHandler.addUser(new User(name, email, password));
                            Toast.makeText(RegisterActivity.this, "Register success!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                            finishAffinity();
                        } else {
                            etPassword.setError("Password can not be empty!");
                        }
                    } else {
                        etEmail.setError("Email can not be empty!");
                    }
                } else {
                    etName.setError("Name can not be empty!");
                }
            }
        });
    }
}
