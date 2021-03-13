package com.azizah.deteksicovid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StatistikActivity extends AppCompatActivity {

    ImageView back, item;
    EditText etedit;
    private Context context;
    private ProgressBar progressBar;
    private RecyclerView rcdata;
    private static final String STATS_URL = "https://api.covid19api.com/summary";
    ArrayList<ModelData> statList;
    AdapterData adapterData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistik);

        back = findViewById(R.id.imageView16);
        progressBar = findViewById(R.id.progresbar);
        etedit = findViewById(R.id.etedit);
        item = findViewById(R.id.itm);
        rcdata = findViewById(R.id.recystat);
        rcdata.setLayoutManager(new LinearLayoutManager(this,  RecyclerView.VERTICAL, false));


        statList = new ArrayList<>();

        rcdata = findViewById(R.id.recystat);
        rcdata.setLayoutManager(new LinearLayoutManager(this));

        // adapterData = new AdapterData(this, dataArrayList);
        //rcdata.setAdapter(adapterData);
        rcdata.setHasFixedSize(true);
        progressBar.setVisibility(View.GONE);

        prosesdata();

        etedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                try{
                    adapterData.getFilter().filter(charSequence);
                    adapterData.notifyDataSetChanged();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        final PopupMenu popupMenu = new PopupMenu(this, item);
        popupMenu.getMenu().add(Menu.NONE,0,0,"A-Z");
        popupMenu.getMenu().add(Menu.NONE,1,1, "Z-A");
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int id = menuItem.getItemId();
                if(id ==0){
                    Collections.sort(statList, new Naik());
                    adapterData.notifyDataSetChanged();
                }
                else if(id==1){
                    Collections.sort(statList, new Turun());
                    adapterData.notifyDataSetChanged();
                }
                return false;
            }
        });

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupMenu.show();
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
                Toast.makeText(StatistikActivity.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void handlerespon(String response) {

        statList = new ArrayList<>();
        statList.clear();

        try{

            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("Countries");

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setDateFormat("dd/MM/yyyy hh:mm a");
            Gson gson = gsonBuilder.create();

            for (int i=0; i<jsonArray.length(); i++){
                ModelData modelData = gson.fromJson(jsonArray.getJSONObject(i).toString(), ModelData.class);

                statList.add(modelData);
            }

            adapterData = new AdapterData(StatistikActivity.this, statList);
            rcdata.setAdapter(adapterData);
            adapterData.notifyDataSetChanged();
            progressBar.setVisibility(View.GONE);

        }
        catch (Exception e){
            Toast.makeText(StatistikActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    public class Naik implements Comparator<ModelData>{

        @Override
        public int compare(ModelData modelData, ModelData t1) {
            return modelData.getCountry().compareTo(t1.getCountry());
        }
    }

    public class Turun implements Comparator<ModelData>{

        @Override
        public int compare(ModelData modelData, ModelData t1) {
            return t1.getCountry().compareTo(modelData.getCountry());
        }
    }

}
