package com.example.finalproject.UserAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.finalproject.R;
import com.example.finalproject.clase.Offer;
import com.example.finalproject.clase.Service;

import java.util.ArrayList;

public class USAdapter extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Service> listService;


    public USAdapter (Activity activity, ArrayList<Service> listService) {
        this.activity = activity;
        this.listService = listService;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View miVista = convertView;
        LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        miVista = inf.inflate(R.layout.activity_u_s_adapter, null);

        Service service =listService.get(position);

        TextView name = miVista.findViewById(R.id.ServiceName);
        name.setText(service.getType());


        return miVista;
    }



    @Override
    public int getCount() {
        return listService.size();
    }

    @Override
    public Object getItem(int position) {
        return listService.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
