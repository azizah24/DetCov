package com.azizah.deteksicovid;

import android.widget.Filter;

import java.util.ArrayList;

public class Searchdata extends Filter {

    private AdapterData adapterData;
    private ArrayList<ModelData> filter;

    public Searchdata(AdapterData adapterData, ArrayList<ModelData> filter) {
        this.adapterData = adapterData;
        this.filter =filter;
    }


    @Override
    protected FilterResults performFiltering(CharSequence c) {

        FilterResults results = new FilterResults();

        if(c != null && c.length() >0){

            c = c.toString().toUpperCase();
            ArrayList<ModelData> modelDataArrayList = new ArrayList<>();
            for(int i=0; i<filter.size(); i++){
                if(filter.get(i).getCountry().toUpperCase().contains(c)){
                    modelDataArrayList.add(filter.get(i));
                }
            }

            results.count = modelDataArrayList.size();
            results.values = modelDataArrayList;
        }

        else{
            results.count = filter.size();
            results.values = filter;
        }
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults results) {

        adapterData.statList = (ArrayList<ModelData>) results.values;

        adapterData.notifyDataSetChanged();

    }
}
