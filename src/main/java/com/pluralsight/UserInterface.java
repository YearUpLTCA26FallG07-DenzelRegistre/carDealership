package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class UserInterface {
    private Dealership dealership;

    public UserInterface(){

    }
    public void display(){
        init();

        String dealershipMenu = """
                -----DealerShipMenu-----
                1 - Find vehicles within a price range
                2 - Find vehicles by make / model
                3 - Find vehicles by year range
                4 - Find vehicles by color
                5 - Find vehicles by mileage range
                6 - Find vehicles by type(car, truck, SUV, van)
                7 - List All vehicles
                8 - Add a vehicle
                9 - Remove a vehicle
                99 - Quit
            
                """;

        int choice;
        do {
            choice = Console.promptForInt(dealershipMenu);
            switch(choice){
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Closing Application");
                default -> System.out.println("Invalid entry, please try again. ");

            }

        } while (choice!= 99);





    }
    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();


    }
    private void displayVehicles(List<Vehicle> vehicles){
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found. ");
            return;
        }
        for (Vehicle v : vehicles){
            System.out.println(v.getVin() + " | " + v.getYear() + " | "
                    + v.getMake() + " | " + v.getModel() + " | "
                    + v.getVehicleType() + " | " + v.getColor() + " | "
                    + v.getOdometer() + " | " + v.getPrice());
        }
    }
    private void processGetByPriceRequest(){

    }
    private void processGetByMakeModelRequest(){

    }
    private void processGetByYearRequest(){

    }
    private void processGetByColorRequest(){

    }
    private void processGetByMileageRequest(){

    }

    private void processGetByVehicleTypeRequest(){

    }
    private void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

    }
    private void processAddVehicleRequest(){

    }

    private void processRemoveVehicleRequest(){

    }


}
