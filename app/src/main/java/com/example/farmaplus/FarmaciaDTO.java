package com.example.farmaplus;

import org.json.JSONObject;

public class FarmaciaDTO {
    private String id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;
    private String ayuntamiento;
    private String cod_provincia;

    public FarmaciaDTO(String id, String nombre, String direccion, String telefono, String horario, String ayuntamiento, String cod_provincia) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.ayuntamiento = ayuntamiento;
        this.cod_provincia = cod_provincia;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getHorario() {
        return horario;
    }

    public String getAyuntamiento() {
        return ayuntamiento;
    }

    public String getCod_provincia() {
        return cod_provincia;
    }
}
