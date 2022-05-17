package com.example.farmaplus;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoritasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FavoritasFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FavoritasFragment newInstance(String param1) {
        FavoritasFragment fragment = new FavoritasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favoritas, container, false);
        SharedPreferences sharedPref = view.getContext().getSharedPreferences("favoritos", 0);
        Set<String> hset = new HashSet<>();
        hset = sharedPref.getStringSet("favoritos", hset);
        List<FarmaciaDTO> farmacias = new ArrayList<>();
        for (String id : hset){
            sharedPref = view.getContext().getSharedPreferences(id, 0);
            Gson gson = new Gson();
            String json = sharedPref.getString(id, "");
            FarmaciaDTO dto = gson.fromJson(json, FarmaciaDTO.class);
            farmacias.add(dto);
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(farmacias);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerFavoritas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));


        return view;
    }
}