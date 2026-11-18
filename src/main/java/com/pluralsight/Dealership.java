package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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
