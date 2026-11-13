package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();


    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max){
return null;
    }
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model){
return null;
    }
    public ArrayList<Vehicle> getVehiclesByYear(BigDecimal min, BigDecimal max){
return null;
    }
    public ArrayList<Vehicle> getVehiclesByColor(String color){
return null;
    }
    public ArrayList<Vehicle> getVehiclesByMileage(BigDecimal min, BigDecimal max){
return null;
    }
    public ArrayList<Vehicle> getVehicleByType(String vehicleType){
return null;
    }
    public ArrayList<Vehicle> getAllVehicles(){
return null;
    }
    public ArrayList<Vehicle>  getVehicle(){
return null;
    }
    public void addVehicle(String vehicle){

    }
    public void revomeVehicle(String vehicle){

    }

}
