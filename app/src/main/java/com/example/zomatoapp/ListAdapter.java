package com.example.zomatoapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zomatoapp.models.model2.Restaurant_;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    List<Restaurant_> myList;
    Context context;

    public ListAdapter(List<Restaurant_> myList, Context context) {
        this.myList = myList;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Log.d("Restaurent",myList.get(10).getName());
        Log.d("Restaurent",myList.get(10).getUserRating().getAggregateRating());
        Log.d("Restaurent",myList.get(10).getLocation().getCity());
        Log.d("Restaurent",myList.get(10).getPhoneNumbers());
        Log.d("Restaurent",myList.get(10).getPriceRange().toString());
        Log.d("Restaurent",myList.get(10).getCurrency());
        View view= LayoutInflater.from(context).inflate(R.layout.list_adapter_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        holder.name.setText(myList.get(position).getName());
        holder.rating.setText(myList.get(position).getUserRating().getAggregateRating());
        holder.location.setText(myList.get(position).getLocation().getCity());
        holder.phone.setText(myList.get(position).getPhoneNumbers());
        holder.price_range.setText(myList.get(position).getPriceRange().toString());
        holder.currency.setText(myList.get(position).getCurrency());
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,location,price_range,currency,phone,rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.restaurant_name);
            location=itemView.findViewById(R.id.location);
            price_range=itemView.findViewById(R.id.price_range);
            currency=itemView.findViewById(R.id.currency);
            phone=itemView.findViewById(R.id.phone);
            rating=itemView.findViewById(R.id.rating);

        }
    }
}
