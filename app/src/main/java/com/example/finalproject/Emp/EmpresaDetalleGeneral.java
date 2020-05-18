package com.example.finalproject.Emp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.clase.Emp;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class EmpresaDetalleGeneral extends AppCompatActivity {

    private Emp emp;

    TextView name;
    TextView description;
    TextView phone;
    TextView email;
    TextView adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_detalle_general);

        name=findViewById(R.id.EDGname);
        description=findViewById(R.id.EDGdescription);
        phone=findViewById(R.id.EDGphone);
        email=findViewById(R.id.EDGemail);
        adress=findViewById(R.id.EDGadress);

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

        name.setText(emp.getName());
        description.setText(emp.getDescription());
        phone.setText(Integer.toString(emp.getNumber()));
        email.setText(emp.getEmail());
        adress.setText(emp.getAdress());

    }
}
