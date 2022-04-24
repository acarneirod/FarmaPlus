package com.example.farmaplus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.List;

public class RecyclerViewAdapter {
    private List<FarmaciaDTO> dtos;
    private Activity activity;

    public RecyclerViewAdapter(List<FarmaciaDTO>dtos,Activity activity){
        this.dtos=dtos;
        this.activity=activity;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder,int position){
        FarmaciaDTO dto = dtos.get(position);
        viewHolder.showData(dto,activity);
    }

    public int getItemCount(){
        return dtos.size();
    }

}
