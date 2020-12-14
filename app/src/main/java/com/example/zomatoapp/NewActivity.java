package com.example.zomatoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.zomatoapp.models.model2.Example;
import com.example.zomatoapp.models.model2.Restaurant;
import com.example.zomatoapp.models.model2.Restaurant_;
import com.example.zomatoapp.webservices.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    double lat,lon;
    List<Restaurant_>myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        myList=new ArrayList<>();

        lat=getIntent().getExtras().getDouble("lat");
        //Log.d("Lat",);
        lon=getIntent().getExtras().getDouble("lon");
        //Log.d("Lat",lon);

        recyclerView=findViewById(R.id.new_recycer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

            Call<Example> call = new ApiClient().getClient().getDetail(lat,lon);

            call.enqueue(new Callback<Example>() {
                @Override
                public void onResponse(Call<Example> call, Response<Example> response) {
                    List<Restaurant>list=response.body().getRestaurants();
                    for(int i=0;i<list.size();i++){
                        myList.add(list.get(i).getRestaurant());
                    }
                    //Log.d("Restaurent names",myList.get(10).getName());
                    recyclerView.setAdapter(new ListAdapter(myList,NewActivity.this));
                }

                @Override
                public void onFailure(Call<Example> call, Throwable t) {

                }
            });
    }
}