package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.clase.Offer;
import com.google.gson.Gson;

public class UsuarioDetalleOferta extends AppCompatActivity {

    private Offer offer;
    private Button emp;

    private TextView type;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalle_oferta);

        Intent myIntent = getIntent();
        getIntent().getSerializableExtra("offerJson");
        Gson gson = new Gson();
        offer =gson.fromJson(getIntent().getStringExtra("offerJson"), Offer.class);

        emp=findViewById(R.id.UDOemp);
        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioDetalleOferta.this,UsuarioDetallesEmpresa.class);
                startActivity(intent);
            }
        });

        type=findViewById(R.id.UDOtype);
        type.setText(offer.getType());

        description=findViewById(R.id.UDOdescription);
        description.setText(offer.getDescription());
    }
}
