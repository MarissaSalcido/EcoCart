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
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FoodDB.db";
    public static final String TABLE_NAME = "Food";
    public static final String COLUMN_CO2 = "CO2_emissions";
    public static final String COLUMN_TYPE = "FoodType";
    public static final String COLUMN_NAME = "FoodName";
    private static final ArrayList<Food> foods = new ArrayList<>(Arrays.asList(new Food("Lamb", 39.2, "Protein"), new Food("Beef", 27.2 , "Protein"),
             new Food("Cheese", 13.5, "Fat"), new Food("Pork", 12.1, "Protein"), new Food("Farmed Salmon", 11.9, "Fat"),
             new Food("Turkey", 10.9, "Protein"), new Food("Chicken", 6.9, "Protein"), new Food("Canned Tune", 6.1, "Fat"),
            new Food("Eggs", 4.8, "Protein"), new Food("Potatoes", 2.9, "Carb"), new Food("Rice", 2.7, "Carb"),
            new Food("Peanut Butter", 2.5, "Fat"), new Food("Nuts", 2.3, "Fat"), new Food("Yogurt", 2.2, "Fat"),
            new Food("Broccoli", 2.0, "Carb"), new Food("Tofu", 2.0, "Protein"), new Food("Dried Beans", 2.0, "Protein"),
            new Food("2% Milk", 1.9, "Protein"), new Food("Tomato", 1.1, "Carb"), new Food("Lentils", 0.9, "Protein")));

    public FoodDatabase(Context context, String name,
                       SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_TYPE +
                "INTEGER PRIMARYKEY," + COLUMN_CO2 + "INTEGER," + COLUMN_NAME + "TEXT )";
        db.execSQL(CREATE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}

    public String loadHandler() {
        String result = "";
        String query = "Select * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()) {
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0) + " " + result_1 +
                    System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }

    public void addHandler(Food food) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_TYPE, food.getType());
        values.put(COLUMN_CO2, food.getCarbonDioxide());
        values.put(COLUMN_NAME, food.getName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Food findHandler(String foodItem) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " = " + "'" + foodItem + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Food food = new Food();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            food.setType(cursor.getString(1));
            food.setCarbonDioxide(Integer.parseInt(cursor.getString(0)));
            food.setName(cursor.getString(1));
            cursor.close();
        } else {
            food = null;
        }
        db.close();
        return food;
    }

    private void addAll(){
        for(Food item: foods) {
            addHandler(item);
        }
    }

    public ArrayList<Food> loadList(String type) {
        ArrayList<Food> result = new ArrayList(1);
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + COLUMN_TYPE + " = " + "'" + type + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Food food = new Food();
        while (cursor.moveToNext()) {
            food.setType(cursor.getString(0));
            food.setCarbonDioxide(Integer.parseInt(cursor.getString(1)));
            food.setName(cursor.getString(2));
            result.add(food);
            cursor.close();
        }
        cursor.close();
        db.close();
        return result;
    }

    //public boolean updateHandler(int ID, String name) {}

}

