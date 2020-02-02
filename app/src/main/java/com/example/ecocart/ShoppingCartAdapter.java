package com.example.ecocart;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.ViewHolder> {

    List<ShoppingCartItem> cart = new ArrayList<>();
    Context context;

    public ShoppingCartAdapter(Context context, List<ShoppingCartItem> cart) {
        this.context = context;
        this.cart = cart;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View foodsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items, parent, false);

        return new ViewHolder(foodsView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ShoppingCartItem item = cart.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return cart.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvFoodText;

        TextView tvCartItemCurrent;
        TextView tvCartItemAlt;
        TextView tvCartItemCurrentCo2;
        TextView tvCartItemAltCo2;
        TextView tvFoodText5;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCartItemCurrent = itemView.findViewById(R.id.tvCartItemCurrent);
            tvCartItemCurrentCo2 = itemView.findViewById(R.id.tvCartItemCurrentCo2);
            tvCartItemAlt = itemView.findViewById(R.id.tvCartItemAlt);
            tvCartItemAltCo2 = itemView.findViewById(R.id.tvCartItemAltCo2);
            tvFoodText5 = itemView.findViewById(R.id.tvFoodText5);
        }

        public void bind(ShoppingCartItem item) {

            // a database of shopping cart item
            FoodDatabase db = new FoodDatabase(context, null, null, 17);


            tvCartItemCurrent.setText(item.getName());
            tvCartItemCurrentCo2.setText(Double.toString(item.getCarbonDioxide()));

            //calculate what alternatives to display to ItemAlt and its co2
/*
            ShoppingCartItem protein_minimal = db.findHandler("Lentils");
            ShoppingCartItem carb_minimal = db.findHandler("Tomato");
            ShoppingCartItem fats_minimal = db.findHandler("Nuts");


            if (item.getName().equals("Protein")) {
                tvCartItemAlt.setText(protein_minimal.getName());
                tvCartItemAltCo2.setText(Double.toString(protein_minimal.getCarbonDioxide()));
                double difference = item.getCarbonDioxide() - protein_minimal.getCarbonDioxide();
                tvFoodText5.setText(Double.toString(difference));
            } else if (item.getName().equals("Carb")) {
                tvCartItemAlt.setText(carb_minimal.getName());
                tvCartItemAltCo2.setText(Double.toString(carb_minimal.getCarbonDioxide()));
                double difference = item.getCarbonDioxide() - carb_minimal.getCarbonDioxide();
                tvFoodText5.setText(Double.toString(difference));
            } else {
                tvCartItemAlt.setText(fats_minimal.getName());
                tvCartItemAltCo2.setText(Double.toString(fats_minimal.getCarbonDioxide()));
                double difference = item.getCarbonDioxide() - fats_minimal.getCarbonDioxide();
                tvFoodText5.setText(Double.toString(difference));
            }*/
        }

    }
}
