package com.example.api.adapter;

import android.app.AlertDialog;
import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.api.R;
import com.example.api.model.CountryModel;



import java.util.ArrayList;

public class CountryAdapter  extends RecyclerView.Adapter<CountryAdapter.viewholder>{
    ArrayList<CountryModel> countryList;
    Context ctx;


    public CountryAdapter(ArrayList<CountryModel> countryList){
        this.countryList=countryList;
        //this.ctx=ctx;

    }


    @NonNull
    @Override

    public CountryAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflator=LayoutInflater.from(viewGroup.getContext());
        String sa=viewGroup.getClass().toString();

        View view= (View) inflator.inflate(R.layout.view_country,viewGroup,false);


        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.viewholder viewHolder, int i) {
        viewHolder.countryTV.setText(countryList.get(i).toString());





    }

    @Override
    public int getItemCount() {
        return countryList.size();

    }

    public class viewholder extends RecyclerView.ViewHolder{

        TextView countryTV;

        public viewholder(@NonNull View itemView) {
            super(itemView);
           countryTV= itemView.findViewById(R.id.tv_country);


        }


    }


}

