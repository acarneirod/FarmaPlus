package com.example.farmaplus;

import android.widget.TextView;

public class ViewHolder {
    private TextView nombre;
    private TextView direccion;
    private TextView telefono;
    private TextView horario;
    private TextView ayuntamiento;
    private FarmaciaDTO dto;

    public ViewHolder(FarmaciaDTO dto) {
        this.nombre.setText(dto.getNombre());
        this.direccion.setText(dto.getDireccion());
        this.telefono.setText(dto.getTelefono());
        this.horario.setText(dto.getHorario());
        this.ayuntamiento.setText(dto.getAyuntamiento());
    }
}
