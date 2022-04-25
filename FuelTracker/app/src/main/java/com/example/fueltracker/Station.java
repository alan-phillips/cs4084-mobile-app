package com.example.fueltracker;

public class Station {
    String name;
    double diesel;
    double petrol;

    public Station() {
    }

    public Station(String name, double diesel, double petrol) {
        this.name = name;
        this.diesel = diesel;
        this.petrol = petrol;

    }

    public String getName(){
        return name;
    }

    public double getDiesel(){
        return diesel;
    }

    public double getPetrol(){
        return petrol;
    }
}
