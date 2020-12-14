package com.example.zomatoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.zomatoapp.models.Example;
import com.example.zomatoapp.models.LocationSuggestion;
import com.example.zomatoapp.models.model2.Restaurant;
import com.example.zomatoapp.models.model2.Restaurant_;
import com.example.zomatoapp.webservices.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SearchView searchView;
    ArrayAdapter<String>arrayAdapter;
    List<String>adapter_list;
    List<LocationSuggestion> suggestionList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter_list=new ArrayList<>();
        searchView=findViewById(R.id.search);
        listView=findViewById(R.id.my_list);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ApiClient apiClient=new ApiClient();
                Call<Example>call=new ApiClient().getClient().getLocation(query);
                call.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        suggestionList=response.body().getLocationSuggestions();
                        for(int i=0;i<suggestionList.size();i++){
                            adapter_list.add(suggestionList.get(i).getTitle());
                        }
                        arrayAdapter=new ArrayAdapter<String>(MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                adapter_list);
                        listView.setAdapter(arrayAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                                intent.putExtra("lat",suggestionList.get(position).getLatitude());
                                intent.putExtra("lon",suggestionList.get(position).getLongitude());
                                adapter_list.clear();
                                startActivity(intent);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {

                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }
}