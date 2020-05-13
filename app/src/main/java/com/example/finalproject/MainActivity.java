package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.User.UsuarioLogIn;
import com.example.finalproject.User.UsuarioRegistrar;

public class MainActivity extends AppCompatActivity {

    Button logIn;
    Button sigIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logIn=findViewById(R.id.UsuarioLog);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UsuarioLogIn.class);
                startActivity(intent);
            }
        });


        sigIn=findViewById(R.id.UsuarioRegistrar);
        sigIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UsuarioRegistrar.class);
                startActivity(intent);
            }
        });
    }


}
