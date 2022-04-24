package com.example.farmaplus;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class ViewHolder {
    private TextView nombre;
    private TextView direccion;
    private TextView telefono;
    private TextView horario;
    private TextView ayuntamiento;
    private FarmaciaDTO dto;

    public ViewHolder(@NonNull View itemView) {
        nombre = (TextView) itemView.findViewById(R.id.nombre);
        direccion = (TextView) itemView.findViewById(R.id.direccion);
        telefono = (TextView) itemView.findViewById(R.id.telefono);
        horario = (TextView) itemView.findViewById(R.id.horario);
        ayuntamiento = (TextView) itemView.findViewById(R.id.ayuntamiento);
    }

    public void showData(FarmaciaDTO dto, Activity activity){
        nombre.setText(dto.getNombre());
        direccion.setText(dto.getDireccion());
        telefono.setText(dto.getTelefono());
        horario.setText(dto.getHorario());
        ayuntamiento.setText(dto.getAyuntamiento());
        this.dto=dto;
    }
}
