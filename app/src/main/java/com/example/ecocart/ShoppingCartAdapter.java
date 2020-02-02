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
        TextView Differencebtn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCartItemCurrent = itemView.findViewById(R.id.tvCartItemCurrent);
            tvCartItemCurrentCo2 = itemView.findViewById(R.id.tvCartItemCurrentCo2);
            tvCartItemAlt = itemView.findViewById(R.id.tvCartItemAlt);
            tvCartItemAltCo2 = itemView.findViewById(R.id.tvCartItemAltCo2);
            tvFoodText5 = itemView.findViewById(R.id.tvFoodText5);
            Differencebtn = itemView.findViewById(R.id.Differencebtn);
        }

        public void bind(ShoppingCartItem item) {

            // a database of shopping cart item
            FoodDatabase db = new FoodDatabase(context, null, null, 17);


            tvCartItemCurrent.setText(item.getName());
            tvCartItemCurrentCo2.setText(Double.toString(item.getCarbonDioxide()*item.getCount()));

            //calculate what alternatives to display to ItemAlt and its co2

            String type = item.getType();
            List<Food> foods = db.loadList(type);
            Food alternative = new Food("min", Double.MAX_VALUE, type);
            for (int i = 0; i < foods.size(); i++){
                if (foods.get(i).getCarbonDioxide() <= alternative.getCarbonDioxide()){
                    alternative = foods.get(i);
                }
            }

            tvCartItemAlt.setText(alternative.getName());
            tvCartItemAltCo2.setText(Double.toString(alternative.getCarbonDioxide()*item.getCount()));
            Differencebtn.setText(Double.toString((item.getCarbonDioxide()*item.getCount()) - (alternative.getCarbonDioxide()*item.getCount())));


            if (alternative.getName().equals(item.getName())){
                tvFoodText5.setText("The item you chose is already the best option!");
            }

        }

    }
}
