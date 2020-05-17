package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.finalproject.R;
import com.example.finalproject.UserAdapter.UOAdapter;

public class UsuarioListadoOfertas extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_listado_ofertas);

        listView=findViewById(R.id.OfferView);
        


        //UOAdapter uoAdapter = new UOAdapter(this,listView);
    }
}
