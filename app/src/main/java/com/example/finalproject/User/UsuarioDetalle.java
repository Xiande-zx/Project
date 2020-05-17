package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.clase.User;
import com.google.gson.Gson;

public class UsuarioDetalle extends AppCompatActivity {

    User user;

    TextView name;
    TextView surname;
    TextView phone;
    TextView age;
    TextView email;
    TextView poblation;
    TextView userName;

    Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle);

        Intent myIntent = getIntent();
        getIntent().getSerializableExtra("userJson");
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("userJson"), User.class);

        name=findViewById(R.id.UDname);
        name.setText(user.getName());

        surname=findViewById(R.id.UDsurname);
        surname.setText(user.getSurname());

        phone=findViewById(R.id.UDphone);
        phone.setText(user.getTelefono());

        age=findViewById(R.id.UDage);
        age.setText(user.getAge());

        email=findViewById(R.id.UDemail);
        email.setText(user.getEmail());

        poblation=findViewById(R.id.UDpoblation);
        poblation.setText(user.getPoblation());

        userName=findViewById(R.id.UDusername);
        userName.setText(user.getUserName());

        create=findViewById(R.id.UDcreate);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioDetalle.this,UsuarioRegistrar.class);
                startActivity(intent);
            }
        });
    }
}
