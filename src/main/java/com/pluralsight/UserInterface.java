package com.pluralsight;

import java.math.BigDecimal;
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
    private void displayVehicles(ArrayList<Vehicle> vehicles){
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
        BigDecimal min = new BigDecimal(Console.promptForString("Minimum price: "));
        BigDecimal max = new BigDecimal(Console.promptForString("Maximum price: "));
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }


    private void processGetByMakeModelRequest(){
        String make = Console.promptForString("Make: ");
        String model = Console.promptForString("Model: ");
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));

    }
    private void processGetByYearRequest(){
        int min = Console.promptForInt("Minimum year: ");
        int max = Console.promptForInt("Maximum year: ");
        displayVehicles(dealership.getVehiclesByYear(min, max));

    }
    private void processGetByColorRequest(){
        String color = Console.promptForString("Color: ");
        displayVehicles(dealership.getVehiclesByColor(color));

    }
    private void processGetByMileageRequest(){
        int min = Console.promptForInt("Minimum mileage: ");
        int max = Console.promptForInt("Maximum mileage: ");
        displayVehicles(dealership.getVehiclesByMileage(min, max));

    }

    private void processGetByVehicleTypeRequest(){
        String type = Console.promptForString("Vehicle type (car, truck, SUV, van): ");
        displayVehicles(dealership.getVehiclesByType(type));

    }
    private void processGetAllVehiclesRequest(){
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);

    }
    private void processAddVehicleRequest(){
        int vin = Console.promptForInt("VIN: ");
        int year = Console.promptForInt("Year: ");
        String make = Console.promptForString("Make: ");
        String model = Console.promptForString("Model: ");
        String type = Console.promptForString("Vehicle type (car, truck, SUV, van): ");
        String color = Console.promptForString("Color: ");
        int odometer = Console.promptForInt("Odometer: ");
        BigDecimal price = new BigDecimal(Console.promptForString("Price: "));

        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odometer, price));
        new DealershipFileManager().saveDealership(dealership);
        System.out.println("Vehicle added and inventory saved.");

    }

    private void processRemoveVehicleRequest(){
        int vin = Console.promptForInt("VIN of vehicle to remove: ");

        Vehicle toRemove = null;
        for (Vehicle v : dealership.getAllVehicles()) {
            if (v.getVin() == vin) {
                toRemove = v;
                break;
            }
        }

        if (toRemove == null) {
            System.out.println("No vehicle found with that VIN.");
            return;
        }

        dealership.removeVehicle(toRemove);
        new DealershipFileManager().saveDealership(dealership);
        System.out.println("Vehicle removed and inventory saved.");


    }


}
