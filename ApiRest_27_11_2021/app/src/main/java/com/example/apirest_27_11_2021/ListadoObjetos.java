package com.example.apirest_27_11_2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListadoObjetos extends AppCompatActivity {

    private List<ObjectoEjercicio> dataset;
    private final static String API_URL_LISTA ="https://jsonplaceholder.typicode.com/posts";
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_objetos);
        ListadoObjetos view=this;
        dataset = new ArrayList<>();
        rq= Volley.newRequestQueue(this);

        RecyclerView rvListaObjetos = findViewById(R.id.rvListaObjetos);
        rvListaObjetos.setLayoutManager(new LinearLayoutManager(this));
        recuperarLista();
        rvListaObjetos.setAdapter(new Adaptador(dataset));



    }
    public void recuperarLista(){
        JsonArrayRequest listaBase = new JsonArrayRequest(Request.Method.GET, API_URL_LISTA, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int x=0; x < response.length(); x++ ){
                    try {
                        JSONObject objeto = new JSONObject(response.get(x).toString());
                        ObjectoEjercicio objetoAux = new ObjectoEjercicio(objeto.getString("id"), objeto.getString("userId"), objeto.getString("title"));
                        dataset.add(objetoAux);
                        Log.d("tag", objetoAux.getTitle());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                RecyclerView rvListaObjetos = findViewById(R.id.rvListaObjetos);
                rvListaObjetos.getAdapter().notifyDataSetChanged();
            }
        },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("[REQUEST ERROR]", error.getMessage());
                }
            }
            );
        rq.add(listaBase);
        }
    }