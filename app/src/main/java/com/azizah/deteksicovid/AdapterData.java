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

    public AdapterData(Context context) {
        this.context = context;
        this.statList = new ArrayList<>();
        this.filter = new ArrayList<>();
    }

    public void addItem(ModelData model) {
        this.statList.add(model);
        this.filter.add(model);
        notifyItemInserted(this.statList.size() -1);
    }

    public void updateItem(ModelData model, int position) {
        this.statList.set(position, model);
        this.filter.set(position, model);
        notifyItemChanged(position);
    }

    public void deleteItem(int position) {
        this.statList.remove(position);
        this.filter.remove(position);
        notifyItemRemoved(position);
        notifyItemMoved(position, this.statList.size() - 1);
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
        return statList.size();
    }

    public void filterData(String keyWord) {
        if (keyWord.length() == 0) {
            this.statList = this.filter;
            notifyDataSetChanged();
        } else {
            this.statList= new ArrayList<>();
            for (ModelData item : this.filter) {
                // filter here
                if (item.toString().toLowerCase().contains(keyWord.toLowerCase())) {
                    this.statList.add(item);
                }
            }
            notifyDataSetChanged();
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
            totalpositif = itemView.findViewById(R.id.negara);
            positifbaru = itemView.findViewById(R.id.negara);
            totalmati = itemView.findViewById(R.id.negara);
            matihariini = itemView.findViewById(R.id.negara);
            totalsembuh = itemView.findViewById(R.id.negara);
            sembuhhariini = itemView.findViewById(R.id.negara);

        }
    }

}
