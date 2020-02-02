
package com.example.ecocart;

import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCartItem {

    // fields
    private String name;
    private double carbonDioxide;
    private String type;
    private int count;

    // constructors
    public ShoppingCartItem() {}

    public ShoppingCartItem(String name, double carbonDioxide, String type, int count) {
        this.name = name;
        this.carbonDioxide = carbonDioxide;
        this.type = type;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCarbonDioxide(double carbonDioxide) {
        this.carbonDioxide = carbonDioxide;
    }

    public double getCarbonDioxide() {
        return this.carbonDioxide;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public String toString()
    {
        return (this.name + ": " + "carbonDioxide: " + this.carbonDioxide);
    }
}