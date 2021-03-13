package com.azizah.deteksicovid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterData extends RecyclerView.Adapter<AdapterData.RecyclerHolder> implements Filterable {

    private Context context;
    public ArrayList<ModelData> statList, filter;
    private Searchdata searchdata;

    public AdapterData(Context context, ArrayList<ModelData> statList) {
        this.context = context;
        this.statList = statList;
        this.filter = statList;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new RecyclerHolder(LayoutInflater.from(context).inflate(R.layout.list_stat, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {

        ModelData modelData = this.statList.get(position);

        String Country = modelData.getCountry();
        String TotalConfirmed = modelData.getTotalConfirmed();
        String NewConfirmed = modelData.getNewConfirmed();
        String TotalDeaths = modelData.getTotalDeaths();
        String NewDeaths = modelData.getNewDeaths();
        String TotalRecovered = modelData.getTotalRecovered();
        String NewRecovered= modelData.getNewRecovered();

        holder.negara.setText(Country);
        holder.totalpositif.setText(TotalConfirmed);
        holder.positifbaru.setText(NewConfirmed);
        holder.totalmati.setText(TotalDeaths);
        holder.matihariini.setText(NewDeaths);
        holder.totalsembuh.setText(TotalRecovered);
        holder.sembuhhariini.setText(NewRecovered);


    }

    @Override
    public int getItemCount() {
        if (statList == null) return 0;
        else {
            return statList.size();
        }
    }


    @Override
    public Filter getFilter() {

        if(searchdata == null){
            searchdata = new Searchdata(this, filter);
        }
        return searchdata;
    }

    class RecyclerHolder extends RecyclerView.ViewHolder{

        TextView negara, totalpositif, positifbaru, totalmati, matihariini, totalsembuh, sembuhhariini;

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);

            negara = itemView.findViewById(R.id.negara);
            totalpositif = itemView.findViewById(R.id.totalpositif);
            positifbaru = itemView.findViewById(R.id.positifhariini);
            totalmati = itemView.findViewById(R.id.totalmati);
            matihariini = itemView.findViewById(R.id.matihariini);
            totalsembuh = itemView.findViewById(R.id.totalsembuh);
            sembuhhariini = itemView.findViewById(R.id.sembuhhariini);

        }
    }

}
