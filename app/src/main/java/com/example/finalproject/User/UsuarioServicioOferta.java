package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.Emp.EmpresaRegistrar;
import com.example.finalproject.R;

public class UsuarioServicioOferta extends AppCompatActivity {

    private Button USOcreateEmp;
    private Button USOuserDetail;

    private Button USOofferList;
    private Button USOserviceList;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_servicio_oferta);

        USOcreateEmp=findViewById(R.id.USOcreateEmp);
        USOcreateEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioServicioOferta.this, EmpresaRegistrar.class);
                startActivity(intent);
            }
        });

        USOuserDetail=findViewById(R.id.USOdetail);
        USOuserDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioServicioOferta.this,UsuarioDetalle.class);
                startActivity(intent);
            }
        });

        USOofferList=findViewById(R.id.USOoffer);
        USOofferList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioServicioOferta.this,UsuarioListadoOfertas.class);
                startActivity(intent);
            }
        });

        USOserviceList=findViewById(R.id.USOservice);
        USOserviceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UsuarioServicioOferta.this,UsuarioListadoServicios.class);
                startActivity(intent);
            }
        });
    }
}
