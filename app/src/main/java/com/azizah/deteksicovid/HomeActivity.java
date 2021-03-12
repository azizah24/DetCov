package com.azizah.deteksicovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {

    private static final String STATS_URL = "https://api.covid19api.com/summary";
    ImageView apaitu, gejala, deteksi, refresh, stat;
    Context context;
    TextView positif, sembuh, mati;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        apaitu = findViewById(R.id.apaitu);
        gejala = findViewById(R.id.gejala);
        deteksi = findViewById(R.id.deteksi);
        refresh = findViewById(R.id.itm);
        stat = findViewById(R.id.imageView10);
        positif = findViewById(R.id.positif);
        sembuh = findViewById(R.id.sembuh);
        mati = findViewById(R.id.mati);
        progressBar = findViewById(R.id.progresbar);
        progressBar.setVisibility(View.GONE);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });


        prosesdata();

        apaitu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apa = new Intent(HomeActivity.this, ApaituActivity.class);
                startActivity(apa);
            }
        });

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apa = new Intent(HomeActivity.this, StatistikActivity.class);
                startActivity(apa);
            }
        });

        gejala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gej = new Intent(HomeActivity.this, GejalaActivity.class);
                startActivity(gej);
            }
        });

        deteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent det = new Intent(HomeActivity.this, DeteksiActivity.class);
                startActivity(det);
            }
        });

    }

    private void prosesdata(){

        progressBar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, STATS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                handlerespon(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void handlerespon(String response) {

        try{

            JSONObject jsonObject = new JSONObject(response);
            JSONObject globalobjek = jsonObject.getJSONObject("Global");
            String totalConfirmed = globalobjek.getString("TotalConfirmed");
            String totalRecovered = globalobjek.getString("TotalRecovered");
            String totalDeaths = globalobjek.getString("TotalDeaths");

            positif.setText(totalConfirmed);
            sembuh.setText(totalRecovered);
            mati.setText(totalDeaths);
            progressBar.setVisibility(View.GONE);

        }
        catch (Exception e){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

}
