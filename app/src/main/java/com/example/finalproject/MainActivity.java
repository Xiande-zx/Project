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
import com.example.finalproject.User.UsuarioServicioOferta;
import com.example.finalproject.clase.User;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

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

                Boolean has = false;

                username=findViewById(R.id.userName);
                password=findViewById(R.id.Rpassword);

                userNameStr=username.getText().toString();
                passwordStr=password.getText().toString();

                if (userNameStr.isEmpty()){
                    error("User name");
                }else if (passwordStr.isEmpty()){
                    error("password");
                }else {
                    String json ="";

                    try {
                        InputStream stream = getAssets().open("User.json");
                        int size = stream.available();
                        byte[] buffer = new byte[size];
                        stream.read(buffer);
                        stream.close();
                        json  = new String(buffer);
                    } catch (Exception e) { }

                    ArrayList<User> listUser  = new ArrayList<User>(Arrays.asList(new Gson().fromJson(json, User[].class)));

                    for (int i = 0; i < listUser.size(); i++ ){
                        if (userNameStr.equalsIgnoreCase(listUser.get(i).getUserName())){
                            has=true;
                            if (passwordStr.equalsIgnoreCase(listUser.get(i).getPassword())){

                                User user = listUser.get(i);

                                Gson gson = new Gson();
                                String userJson = gson.toJson(user);

                                Intent intent = new Intent(MainActivity.this, UsuarioServicioOferta.class);
                                intent.putExtra("userJson", userJson);
                                startActivity(intent);
                            }else{
                                Context context = getApplicationContext();
                                CharSequence text = "Contrasenya incorrecta!";
                                int duration = Toast.LENGTH_SHORT;

                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                            }
                        }
                    }
                    if (has==false){
                        Context context = getApplicationContext();
                        CharSequence text = "No existeix l'usuari";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }

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
