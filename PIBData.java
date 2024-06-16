package com.example.assignment1;

public class PIBData {
    private final int year;
    private final double gdp;
//Setters
    public PIBData(int year, double gdp) {
        this.year = year;
        this.gdp = gdp;
    }
//Getters
    public int getYear() {
        return year;
    }

    public double getGdp() {
        return gdp;
    }
}
