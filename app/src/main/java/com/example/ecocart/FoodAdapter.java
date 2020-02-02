package com.example.ecocart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {


    private final List<Food> foods;
    List<String> shoppingCart;
    public ImageView addItemButton;

    Context context;


    public FoodAdapter(Context context, List<Food> foods, List<String> shoppingCart) {
        this.foods = foods;
        this.context = context;
        this.shoppingCart = shoppingCart;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View foodsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food, parent, false);

        return new ViewHolder(foodsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String food = foods.get(position).getName();
        holder.bind(food);
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFoodItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFoodItem = itemView.findViewById(R.id.tvFoodItem);
            addItemButton = itemView.findViewById(R.id.addItemButton);
            addItemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String item = tvFoodItem.getText().toString();
                    FoodDatabase db = new FoodDatabase(context, null, null, 17);
                    Food food = db.getFoodItem(item);
                    if (db.findHandler(item) == null){
                        Toast.makeText(context, "Updated shopping list!", Toast.LENGTH_SHORT).show();
                        ShoppingCartItem newItem = new ShoppingCartItem(food.getName(), food.getCarbonDioxide(), food.getType(), 1);
                        db.addToCart(newItem);
                        System.out.println(newItem.getName());
                    }
                    else{
                        ShoppingCartItem newItem = db.findHandler(item);
                        db.removeFromCart(newItem.getName());
                        ShoppingCartItem addedItem = new ShoppingCartItem(newItem.getName(), newItem.getCarbonDioxide(), newItem.getType(), newItem.getCount()+1);
                        db.addToCart(addedItem);
                        Toast.makeText(context, "Updated shopping list!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bind(String food) {
            tvFoodItem.setText(food);
        }

    }
}
