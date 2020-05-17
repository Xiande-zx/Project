package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.clase.Emp;

public class UsuarioDetallesEmpresa extends AppCompatActivity {

    private TextView name;
    private TextView description;
    private TextView number;
    private TextView email;
    private TextView adress;

    Emp emp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_detalles_empresa);

        emp = new Emp();

        name=findViewById(R.id.UDEnom);
        name.setText(emp.getName());

        description=findViewById(R.id.UDEdescription);
        description.setText(emp.getName());

        number=findViewById(R.id.UDEnumber);
        number.setText(emp.getNumber());

        email=findViewById(R.id.UDEemail);
        email.setText(emp.getEmail());

        adress=findViewById(R.id.UDEadress);
        adress.setText(emp.getAdress());

    }
}
