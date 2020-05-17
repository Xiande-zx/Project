package com.example.finalproject.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.finalproject.R;
import com.example.finalproject.UserAdapter.UOAdapter;
import com.example.finalproject.clase.Offer;
import com.google.gson.Gson;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class UsuarioListadoOfertas extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_listado_ofertas);

        listView=findViewById(R.id.OfferView);

        String json ="";

        try {
            InputStream stream = getAssets().open("OfferList.json");
            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            json  = new String(buffer);
        } catch (Exception e) { }

        final ArrayList<Offer> list  = new ArrayList<Offer>(Arrays.asList(new Gson().fromJson(json, Offer[].class)));

        UOAdapter uoAdapter = new UOAdapter(this,list);

        listView.setAdapter(uoAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Offer offer = new Offer(list.get(position).getId(),list.get(position).getType(),list.get(position).getDescription());
                Gson gson = new Gson();
                String offerJson = gson.toJson(offer);

                Intent activity2Intent = new Intent(getApplicationContext(), UsuarioDetalleOferta.class);
                activity2Intent.putExtra("offerJson", offerJson);
                startActivity(activity2Intent);

            }
        });

    }
}
