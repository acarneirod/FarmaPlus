package com.example.farmaplus;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ViewHolder extends RecyclerView.ViewHolder {
    private String id;
    private TextView nombre;
    private TextView direccion;
    private TextView telefono;
    private TextView horario;
    private TextView ayuntamiento;
    private FarmaciaDTO dto;
    private ToggleButton favorito;
    private View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        nombre = (TextView) itemView.findViewById(R.id.nombre);
        direccion = (TextView) itemView.findViewById(R.id.direccion);
        telefono = (TextView) itemView.findViewById(R.id.telefono);
        horario = (TextView) itemView.findViewById(R.id.horario);
        ayuntamiento = (TextView) itemView.findViewById(R.id.ayuntamiento);
        favorito = (ToggleButton) itemView.findViewById(R.id.favorito);
        view = itemView;
        favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = v.getContext().getSharedPreferences("favoritos", 0);
                SharedPreferences.Editor editor = sharedPref.edit();
                Set<String> hset = new HashSet<>();
                hset = sharedPref.getStringSet("favoritos", hset);
                if(favorito.isChecked()==true){
                    hset.add(id);
                    editor.putStringSet("favoritos",hset);
                    editor.commit();

                    sharedPref = v.getContext().getSharedPreferences(id, 0);
                    editor = sharedPref.edit();
                    Gson gson = new Gson();
                    String json = gson.toJson(dto);
                    editor.putString(id,json);
                    editor.commit();
                }else{
                    hset.remove(id);
                    editor.putStringSet("favoritos",hset);
                    editor.commit();
                }

            }
        });
    }

    public void showData(FarmaciaDTO dto){
        id = dto.getId();
        nombre.setText(dto.getNombre());
        direccion.setText(dto.getDireccion());
        telefono.setText(dto.getTelefono());
        horario.setText(dto.getHorario());
        ayuntamiento.setText(dto.getAyuntamiento());
        SharedPreferences sharedPref = view.getContext().getSharedPreferences("favoritos", 0);
        Set<String> hset = new HashSet<>();
        hset = sharedPref.getStringSet("favoritos", hset);
        if(hset.contains(id)){
            favorito.setChecked(true);
        }else{
            favorito.setChecked(false);
        }
        this.dto=dto;
    }
}

