package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        user = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPassword);
        login = findViewById(R.id.btnLog);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(user.getText().toString().equalsIgnoreCase("admin") && pass.getText().toString().equals("Password"))
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(getApplicationContext(),"Invalid username or paswwrd",Toast.LENGTH_LONG).show();
    }
}
