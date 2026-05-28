package com.example.practica02;

import android.os.Bundle;
import android.widget.EditText;
import org.json.JSONArray;
import java.util.Map;
import java.util.HashMap;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class apirest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apirest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText txtAlumnos = findViewById(R.id.txtDatos);

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "https://reqres.in/api/collections/alumnos/records?x-api-key=pub_bf56644bb321c3b811fdd148594b6f596de208551a5d8fc67e5e632f08e013a1",
                null,
                response -> {
                    try {
                        StringBuilder texto = new StringBuilder();
                        JSONArray data = response.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++){
                            JSONObject jsonAlumno = data.getJSONObject(i).getJSONObject("data");
                            texto.append((i+1) + " " + jsonAlumno.optString("nombres", ""));
                            texto.append("Correo: " + jsonAlumno.optString("correo", "") + "\n");
                            texto.append("Paralelo: " + jsonAlumno.optString("paralelo", "") + "\n");
                            texto.append("Periodo: " + jsonAlumno.optString("periodoacademico", "") + "\n");

                        }
                        //texto.append(agregarAlumnosALista(data.getJSONObject(i), i+1));

                        txtAlumnos.setText(texto.toString());

                    } catch (Exception e) {
                        txtAlumnos.setText("Error procesando datos:\n" + e.getMessage());
                    }
                },
                //new ApiErrorListener(this)
                error -> txtAlumnos.setText("Error API:\n" + error.getMessage())
        ){
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("x-api-key", "pub_bf56644bb321c3b811fdd148594b6f596de208551a5d8fc67e5e632f08e013a1");
                return headers;
            }
        };

        queue.add(request);
    }

}