package com.yash.fooddonationapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DonorRVAdapter extends RecyclerView.Adapter<DonorRVAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<FoodDetailsPostDBhandler> coursesArrayList;
    private Context context;

    // creating constructor for our adapter class
    public DonorRVAdapter(ArrayList<FoodDetailsPostDBhandler> coursesArrayList, Context context) {
        this.coursesArrayList = coursesArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DonorRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.donorlist_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DonorRVAdapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        FoodDetailsPostDBhandler food = coursesArrayList.get(position);
        holder.NameTV.setText(food.getPostName());
        holder.QunatTV.setText(food.getQuantText());
        holder.PerishablityTV.setText(food.getperishability());
        holder.NutritionTV.setText(food.getnutritionalValue());
        holder.FedTV.setText(food.getpersonsFed());
        holder.DescTV.setText(food.getDonorFoodDetails());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return coursesArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView NameTV;
        private final TextView DescTV;
        private final TextView FedTV;
        private final TextView NutritionTV;
        private final TextView PerishablityTV;
        private final TextView QunatTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            NameTV = itemView.findViewById(R.id.idTVName);
            NutritionTV = itemView.findViewById(R.id.idTVNutrition);
            DescTV = itemView.findViewById(R.id.idTVDesc);
            FedTV = itemView.findViewById(R.id.idTVFed);
            QunatTV = itemView.findViewById(R.id.idTVQuant);
            PerishablityTV = itemView.findViewById(R.id.idTVPerishablity);
        }
    }
}
