package com.example.farmaplus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CercanasFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CercanasFragment() {
        // Required empty public constructor
    }

    public static CercanasFragment newInstance(String param1) {
        CercanasFragment fragment = new CercanasFragment();
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

        View view = inflater.inflate(R.layout.fragment_cercanas, container, false);

        String url = "https://625058afe3e5d24b3420b189.mockapi.io/farmacia?search=" + codigoProvinciaGeolocalizado();
        JsonArrayRequest peticion = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        List<FarmaciaDTO> farmacias = new ArrayList<>();
                        for(int i=0;i<response.length();i++){
                            try{
                                JSONObject farmacia = response.getJSONObject(i);
                                FarmaciaDTO farmaciaDTO = new FarmaciaDTO(farmacia.getString("nombre"),
                                        farmacia.getString("direccion"),
                                        farmacia.getString("telefono"),
                                        farmacia.getString("horario"),
                                        farmacia.getString("ayuntamiento"),
                                        farmacia.getString("cod_provincia"),
                                        farmacia.getString("id"));
                                farmacias.add(farmaciaDTO);
                            }catch(JSONException e){
                                e.printStackTrace();
                            }
                        }
                        RecyclerViewAdapter adapter = new RecyclerViewAdapter(farmacias);
                        RecyclerView recyclerView = view.findViewById(R.id.recyclerCercanas);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
                        recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        RequestQueue cola = Volley.newRequestQueue(view.getContext());
        cola.add(peticion);

        return view;
    }

    private String codigoProvinciaGeolocalizado(){
        //TODO
        return "ES-C";
    }
}