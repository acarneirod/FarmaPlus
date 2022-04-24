package com.example.farmaplus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<FarmaciaDTO> dtos;

    public RecyclerViewAdapter(List<FarmaciaDTO>dtos){
        this.dtos=dtos;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder,parent,false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder viewHolder,int position){
        FarmaciaDTO dto = dtos.get(position);
        viewHolder.showData(dto);
    }

    public int getItemCount(){
        return dtos.size();
    }

}
