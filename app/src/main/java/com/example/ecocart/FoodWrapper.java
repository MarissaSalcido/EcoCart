package com.example.ecocart;

import java.io.Serializable;
import java.util.ArrayList;

public class FoodWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Food> foods;

    public FoodWrapper(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }
}