package com.example.ecocart;

public class Food {

    // fields
    private String name;
    private double carbonDioxide;
    private String type;

    // constructors
    public Food() {}
    public Food(String name, double carbonDioxide, String type) {
        this.name = name;
        this.carbonDioxide = carbonDioxide;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCarbonDioxide(float carbonDioxide) {
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
}