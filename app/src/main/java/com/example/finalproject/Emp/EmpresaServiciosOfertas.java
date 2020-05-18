package com.example.finalproject.Emp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.finalproject.R;
import com.example.finalproject.clase.Emp;
import com.example.finalproject.clase.User;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class EmpresaServiciosOfertas extends AppCompatActivity {

    private Emp emp;

    Button empDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_servicios_ofertas);

        empDetail=findViewById(R.id.ESOdetail);

        Intent intent = getIntent();
        final int temp = intent.getIntExtra("idEmp",0);

        String json ="";

        try {
            InputStream stream = getAssets().open("Emp.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json  = new String(buffer);
        } catch (Exception e) { }

        ArrayList<Emp> listEmp  = new ArrayList<Emp>(Arrays.asList(new Gson().fromJson(json, Emp[].class)));

        for(int i = 0; i < listEmp.size(); i++){
            if (listEmp.get(i).getId()==temp){
                emp = listEmp.get(i);
            }
        }

        empDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmpresaServiciosOfertas.this,EmpresaDetalleGeneral.class);
                intent.putExtra("idEmp",temp);
                startActivity(intent);
            }
        });
    }
}
