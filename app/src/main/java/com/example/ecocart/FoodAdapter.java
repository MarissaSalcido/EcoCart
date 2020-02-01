package com.example.ecocart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {


    private final List<Food> foods;

    public FoodAdapter(List<Food> foods) {
        this.foods = foods;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View foodsView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(foodsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String food = String.valueOf(foods.get(position)); // might need to fix
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFood = itemView.findViewById(android.R.id.text1);

        }

        public void bind(String food) {
            tvFood.setText(food);
        }
    }
}
