package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.finalproject.User.UsuarioDetalle;
import com.example.finalproject.User.UsuarioRegistrar;

public class MainActivity extends AppCompatActivity {

    Button logIn;
    Button sigIn;
    EditText username;
    EditText password;
    String userNameStr;
    String passwordStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        logIn=findViewById(R.id.UsuarioLog);
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=findViewById(R.id.userName);
                password=findViewById(R.id.Rpassword);

                userNameStr=username.getText().toString();
                passwordStr=password.getText().toString();

                if (userNameStr.isEmpty()){
                    error("User name");
                }else if (passwordStr.isEmpty()){
                    error("password");
                }else {
                    Intent intent = new Intent(MainActivity.this, UsuarioDetalle.class);
                    startActivity(intent);
                }

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

    public void error(String str){
        Context context = getApplicationContext();
        CharSequence text = "El camp "+str+" no pot estar buit!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


}
