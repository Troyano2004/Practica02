package com.example.practica02;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PractApiRest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pract_api_rest);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText txtAlumnos = findViewById(R.id.txtDatos);
        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                "https://pzxbvkmkbhvjpdbqkeus.supabase.co/rest/v1/alumnos",
                null,
                response -> {
                    try {
                        StringBuilder texto = new StringBuilder();
                        for (int i = 0; i < response.length(); i++) {
                            JSONObject jsonAlumno = response.getJSONObject(i);
                            texto.append((i + 1) + " " + jsonAlumno.optString("apellidos_nombres", "") + "\n");
                            texto.append("Cedula: " + jsonAlumno.optString("cedula", "") + "\n");
                            texto.append("Correo: " + jsonAlumno.optString("correo_institucional", "") + "\n");
                            texto.append("Correo MS: " + jsonAlumno.optString("correo_microsoft", "") + "\n\n");
                        }
                        txtAlumnos.setText(texto.toString());
                    } catch (Exception e) {
                        txtAlumnos.setText("Error procesando datos:\n" + e.getMessage());


                    }
                },
                error -> txtAlumnos.setText("Error API:\n" + error.getMessage())
        ) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("apikey", "sb_publishable_LhcA6P4rR_GaTmdlxqO9Rg_3G0o7k5s");
                headers.put("Authorization", "Bearer sb_publishable_LhcA6P4rR_GaTmdlxqO9Rg_3G0o7k5s");
                return headers;
            }
        };

        queue.add(request);
    }
}