
package com.example.ecocart;

import org.parceler.Parcel;

import java.io.Serializable;
import java.util.ArrayList;

@Parcel
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

    public String toString()
    {
        return (this.name + ": " + "carbonDioxide: " + this.carbonDioxide);
    }
}