package com.example.api;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.api.adapter.CountryAdapter;
import com.example.api.model.CountryModel;

import java.util.ArrayList;
import com.example.api.Api;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
RecyclerView rvCountryName;
ArrayList<CountryModel> alCountry=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
rvCountryName=findViewById(R.id.rv_country);
rvCountryName.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api=retrofit.create(Api.class);
        Call<ArrayList<CountryModel>> call=api.getCountryName();
        call.enqueue(new Callback<ArrayList<CountryModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CountryModel>> call, Response<ArrayList<CountryModel>> response) {
                alCountry=response.body();
                rvCountryName.setAdapter(new CountryAdapter(alCountry));
            }

            @Override
            public void onFailure(Call<ArrayList<CountryModel>> call, Throwable t) {

            }
        });

    }

}
