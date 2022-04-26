package com.example.farmaplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BuscadorFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public BuscadorFragment() {
        // Required empty public constructor
    }

    public List<FarmaciaDTO> hardcode(){
        List<FarmaciaDTO> dtos = new ArrayList<FarmaciaDTO>();
        FarmaciaDTO dto1 = new FarmaciaDTO("1","ALMOZARA SUÁREZ, JOSHUA","Seoane - Barcala - A Baña","981885864","09:30 - 09:30 (+1)","A Baña","ES-C");
        FarmaciaDTO dto2 = new FarmaciaDTO("2","ÁLVAREZ SOAJE, MIGUEL ÁNGEL Y GARCÍA MONTAÑA, YOLANDA","Apeadero de Perbes, 16, (Perbes (San Pedro)) - Miño","981783370","09:00 - 22:00","Arzúa","ES-C");
        FarmaciaDTO dto3 = new FarmaciaDTO("3","BARREIRO SALVADO, JUAN JOSÉ","c/Neira Vilas 2 - Arzúa","981500006","09:00 - 09:30 (+1)","Miño","ES-C");
        dtos.add(dto1);
        dtos.add(dto2);
        dtos.add(dto3);
        return dtos;
    }

    public static BuscadorFragment newInstance(String param1) {
        BuscadorFragment fragment = new BuscadorFragment();
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

        View view = inflater.inflate(R.layout.fragment_buscador, container, false);
        List<FarmaciaDTO> dtos = hardcode();
        RecyclerView recyclerView = view.findViewById(R.id.recyclerBuscador);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(dtos);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getContext(),DividerItemDecoration.VERTICAL));
        return view;
    }
}