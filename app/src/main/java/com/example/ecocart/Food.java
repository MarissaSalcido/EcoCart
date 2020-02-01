package com.example.ecocart;

public class Food {

    // fields
    private string name;
    private float carbonDioxide;
    private string type;

    // constructors
    public Food() {}
    public Food(string name, float carbonDioxide, string type) {
        this.name = name;
        this.carbonDioxide = carbonDioxide;
        this.type = type;
    }

    public void setName(string name) {
        this.name = name;
    }

    public string getName() {
        return this.name;
    }

    public void setCarbonDioxide(float carbonDioxide) {
        this.carbonDioxide = carbonDioxide;
    }

    public float getCarbonDioxide() {
        return this.carbonDioxide;
    }

    public void setType(string type) {
        this.type = type;
    }

    public string getType() {
        return this.type;
    }
}