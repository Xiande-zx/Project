package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.clase.Offer;
import com.example.finalproject.clase.Service;
import com.google.gson.Gson;

public class UsuarioDetalleServicio extends AppCompatActivity {

    Service service;

    private TextView type;
    private TextView description;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle_servicio);

        Intent myIntent = getIntent();
        getIntent().getSerializableExtra("serviceJson");
        Gson gson = new Gson();
        service =gson.fromJson(getIntent().getStringExtra("serviceJson"), Service.class);

        type=findViewById(R.id.UDStype);
        type.setText(service.getType());

        description=findViewById(R.id.UDSdescription);
        description.setText(service.getDescription());

        button=findViewById(R.id.UDEconfirm);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioDetalleServicio.this,UsuarioDetallesEmpresa.class);
                startActivity(intent);
            }
        });
    }
}
