package com.example.apirest_27_11_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    
    private EditText etUserId, etUserName, etName, etUserEmail;
    private Button btSendAction;
    private final static String API_URL1 ="https://jsonplaceholder.typicode.com/users/";
    public String API_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserId= findViewById(R.id.etUserId);
        etUserName= findViewById(R.id.etUserName);
        etName= findViewById(R.id.etName);
        etUserEmail= findViewById(R.id.etEmail);
        btSendAction= findViewById(R.id.btSendAction);

    }
    public void sendRequest(View view){
        API_URL =API_URL1 + etUserId.getText().toString();
        makeGetRequest();
    }
    private void makeGetRequest(){
        StringRequest strRequest = new StringRequest(Request.Method.GET, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject responseObject = new JSONObject(response);
                    String userId= responseObject.getString("id");
                    String name= responseObject.getString("name");
                    String username= responseObject.getString("username");
                    String email= responseObject.getString("email");
                    etUserId.setText(userId);
                    etName.setText(name);
                    etUserName.setText(username);
                    etUserEmail.setText(email);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("[REQUEST ERROR]", error.getMessage());
            }
        }
        );
        Volley.newRequestQueue(this).add(strRequest);
    }


    public void irListado(View view) {
        Intent listadoObj = new Intent(this, ListadoObjetos.class);
        startActivity(listadoObj);
    }
}