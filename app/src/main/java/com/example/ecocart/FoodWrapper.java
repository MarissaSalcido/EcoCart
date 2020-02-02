package com.example.ecocart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FoodWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Food> foods;

    public FoodWrapper(List<Food> foods) {
        this.foods = foods;
    }

    public List<Food> getFoods() {
        return foods;
    }
}