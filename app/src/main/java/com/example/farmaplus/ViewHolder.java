package com.example.farmaplus;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
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
                SharedPreferences sharedPref = v.getContext().getSharedPreferences("favorites",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(nombre.getText().toString(), favorito.isChecked());
                editor.apply();
            }
        });
    }

    public void showData(FarmaciaDTO dto){
        nombre.setText(dto.getNombre());
        direccion.setText(dto.getDireccion());
        telefono.setText(dto.getTelefono());
        horario.setText(dto.getHorario());
        ayuntamiento.setText(dto.getAyuntamiento());
        SharedPreferences sharedPref = view.getContext().getSharedPreferences("favorites",0);
        favorito.setChecked(sharedPref.getBoolean(nombre.getText().toString(),false));
        this.dto=dto;
    }
}
