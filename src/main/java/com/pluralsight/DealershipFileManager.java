package com.pluralsight;

import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {
    private static String inventory = "inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;

        try {
            FileReader fileReader = new FileReader(inventory);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            String[] info = line.split("\\|");
            dealership = new Dealership(info[0], info[1], info[2]);


            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                BigDecimal price = new BigDecimal(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle((vehicle));

            }


        } catch (IOException e) {
            System.out.println("Error reading inventory.csv: " + e.getMessage());
        }
        return dealership;
    }



    public void saveDealership(Dealership dealership){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inventory))) {
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            writer.newLine();

            for (Vehicle v : dealership.getAllVehicles()) {
                writer.write(v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|"
                        + v.getModel() + "|" + v.getVehicleType() + "|" + v.getColor() + "|"
                        + v.getOdometer() + "|" + v.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving " + inventory + ": " + e.getMessage());
        }
    }


}
