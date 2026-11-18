package com.pluralsight;

public class UserInterFace {
    private Dealership dealership;

    public UserInterFace(){

    }
    public void diplay(){
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
                case 2 -> processGetByMakeModeRequest();
                case 3 -> processGetByColorRequest();
                case 4 -> processGetByMileageRequest();
                case 5 -> processGetByVehicleTypeRequest();
                case 6 -> processGetAllVehicleRequest();
                case 7 -> processAddVehicleRequest();
                case 8 -> processRemoveVehicleRequest();
                case 99 -> System.out.println("Good Bye");
                default -> System.out.println("Invalid entry, please try again. ");

            }

        } while (choice!= 99);





    }
    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();

        System.out.println("Loaded: " + dealership.getName());
    }
    public void processGetByPriceRequest(){

    }
    public void processGetByMakeModeRequest(){

    }
    public void processGetByColorRequest(){

    }
    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }
    public void processGetAllVehicleRequest(){

    }
    public void processAddVehicleRequest(){

    }

    public void processRemoveVehicleRequest(){

    }


}
