package com.example.ecocart;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {


    private final List<Food> foods;
    public ImageView addItemButton;

    Context context;


    public FoodAdapter(Context context, List<Food> foods) {
        this.foods = foods;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View foodsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food, parent, false);

        return new ViewHolder(foodsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //String food = String.valueOf(foods.get(position)); // might need to fix
        String food = foods.get(position).getName();
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFoodText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFoodText = itemView.findViewById(R.id.tvFoodText);
            addItemButton = itemView.findViewById(R.id.addItemButton);


            addItemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // do your stuffs
//                    Log.d("TEST", "clicked");
//                    System.out.println(v);
//                    System.out.println(this);
//                    System.out.println(tvFoodText);
//
//                    System.out.println();

//                    View test = (View) v.getParent();
//                    test.findViewById(R.id.tvFoodText);
//                    System.out.println(test);

                    Intent intent = new Intent("add-food");
                    intent.putExtra("item", tvFoodText.getText());
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
                }
            });

        }

        public void bind(String food) {
            tvFoodText.setText(food);
        }

    }
}
