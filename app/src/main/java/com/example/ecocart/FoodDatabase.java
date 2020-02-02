package com.example.ecocart;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "FoodDB.db";
    public static final String FOOD_TABLE_NAME = "Food";
    public static final String COLUMN_CO2 = "CO2_emissions";
    public static final String COLUMN_TYPE = "FoodType";
    public static final String COLUMN_NAME = "FoodName";
    private static final ArrayList<Food> foods = new ArrayList<>(Arrays.asList(new Food("Lamb", 39.2, "Protein"), new Food("Beef", 27.2 , "Protein"),
             new Food("Cheese", 13.5, "Fat"), new Food("Pork", 12.1, "Protein"), new Food("Farmed Salmon", 11.9, "Fat"),
             new Food("Turkey", 10.9, "Protein"), new Food("Chicken", 6.9, "Protein"), new Food("Canned Tuna", 6.1, "Fat"),
            new Food("Eggs", 4.8, "Protein"), new Food("Potatoes", 2.9, "Carb"), new Food("Rice", 2.7, "Carb"),
            new Food("Peanut Butter", 2.5, "Fat"), new Food("Nuts", 2.3, "Fat"), new Food("Yogurt", 2.2, "Fat"),
            new Food("Broccoli", 2.0, "Carb"), new Food("Tofu", 2.0, "Protein"), new Food("Dried Beans", 2.0, "Protein"),
            new Food("2% Milk", 1.9, "Protein"), new Food("Tomato", 1.1, "Carb"), new Food("Lentils", 0.9, "Protein")));
    public static final String SHOPPING_TABLE_NAME = "Shopping";
    public static final String SHOPPING_CO2 = "CO2_emissions";
    public static final String SHOPPING_TYPE = "FoodType";
    public static final String SHOPPING_NAME = "FoodName";
    public static final String SHOPPING_AMOUNT = "Amount";


    public FoodDatabase(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_FOODS = "CREATE TABLE " + FOOD_TABLE_NAME + "(" + COLUMN_TYPE +
                " TEXT, " + COLUMN_CO2 + "  REAL, " + COLUMN_NAME + "  TEXT" + ");";
        String CREATE_TABLE_SHOPPING = "CREATE TABLE " + SHOPPING_TABLE_NAME + "(" + SHOPPING_TYPE +
                " TEXT, " + SHOPPING_CO2 + "  REAL, " + SHOPPING_NAME + "  TEXT, " + SHOPPING_AMOUNT + " INTEGER" + ");";
        db.execSQL(CREATE_TABLE_FOODS);
        db.execSQL(CREATE_TABLE_SHOPPING);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SHOPPING_TABLE_NAME);
        onCreate(db);
    }

    public void addHandler(Food food) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TYPE, food.getType());
        values.put(COLUMN_CO2, food.getCarbonDioxide());
        values.put(COLUMN_NAME, food.getName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(FOOD_TABLE_NAME, null, values);
        db.close();
    }

    public void addToCart(ShoppingCartItem shopping)  {
        ContentValues values = new ContentValues();
        values.put(SHOPPING_TYPE, shopping.getType());
        values.put(SHOPPING_CO2, shopping.getCarbonDioxide());
        values.put(SHOPPING_NAME, shopping.getName());
        values.put(SHOPPING_AMOUNT, shopping.getCount());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(SHOPPING_TABLE_NAME, null, values);
        db.close();
    }

    public boolean removeFromCart(String name) {
        boolean result = false;
        String query = "Select * FROM " + SHOPPING_TABLE_NAME + " WHERE " + SHOPPING_NAME + " = " + "'" + name + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ShoppingCartItem item = new ShoppingCartItem();
        if(cursor.moveToFirst()) {
            item.setName(cursor.getString(2));
            db.delete(SHOPPING_TABLE_NAME, SHOPPING_NAME + "=?", new String[]{item.getName()});
            cursor.close();
            result = true;
        }
        db.close();
        return result;
    }

    public void addAll(){
        for(Food item: foods) {
            addHandler(item);
        }
    }

    public List<Food> loadList(String type) {
        List<Food> result = new ArrayList<Food>();
        String query = "Select * FROM " + FOOD_TABLE_NAME + " WHERE " + COLUMN_TYPE + " = " + "'" + type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            Food food = new Food();
            food.setType(cursor.getString(0));
            food.setCarbonDioxide(Double.parseDouble(cursor.getString(1)));
            food.setName(cursor.getString(2));
            result.add(food);
        }
        cursor.close();
        db.close();
        return result;
    }

    public List<ShoppingCartItem> loadCart(String type) {
        List<ShoppingCartItem> result = new ArrayList<ShoppingCartItem>();
        String query = "Select * FROM " + FOOD_TABLE_NAME + " WHERE " + SHOPPING_TYPE + " = " + "'" + type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            ShoppingCartItem item = new ShoppingCartItem();
            item.setType(cursor.getString(0));
            item.setCarbonDioxide(Double.parseDouble(cursor.getString(1)));
            item.setName(cursor.getString(2));
            item.setCount(Integer.parseInt(cursor.getString(3)));
            result.add(item);
        }
        cursor.close();
        db.close();
        return result;
    }
    //public boolean updateHandler(int ID, String name) {}

}

