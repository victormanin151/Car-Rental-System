package utils;

import cars.CarStatus;
import cars.Cars;
import services.CarService;

import java.util.List;
import java.util.Scanner;

public class CarMenu {
    public static void addCarMenu(Scanner s) {
        System.out.println("***************");
        System.out.println("Add a New Car");
        System.out.println("***************");

        System.out.print("Enter make: ");
        String make = s.nextLine();

        System.out.print("Enter model: ");
        String model = s.nextLine();

        int year;
        while (true) {
            try {
                System.out.print("Enter year (example: 2020): ");
                year = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid number between 1886 and 2025.");
            }
        }

        System.out.print("Enter type (example: Sedan, SUV, Truck): ");
        String type = s.nextLine();

        CarService.addCar(make, model, year, type, CarStatus.AVAILABLE);

        System.out.println("**************************");
        System.out.println("Car successfully added!");
        System.out.println("**************************");
    }

    public static void changeCarStatusMenu(Scanner s) {
        System.out.print("Enter the Car ID to change status: ");
        int carID = Integer.parseInt(s.nextLine());

        System.out.println("Select new status:");
        for (CarStatus status : CarStatus.values()) {
            System.out.println(status.ordinal() + " - " + status);
        }

        int statusChoice;
        while (true) {
            try {
                System.out.print("Enter choice: ");
                statusChoice = Integer.parseInt(s.nextLine());
                if (statusChoice >= 0 && statusChoice < CarStatus.values().length) {
                    break;
                } else {
                    System.out.println("Invalid choice, try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again.");
            }
        }

        CarStatus selectedStatus = CarStatus.values()[statusChoice];
        boolean success = CarService.updateCarStatus(carID, selectedStatus);

        if (success) {
            System.out.println("Car status updated successfully to " + selectedStatus);
        } else {
            System.out.println("Car with ID " + carID + " not found.");
        }
    }


    public static void editCarMenu(Scanner s) {
        System.out.print("Enter the Car ID to edit: ");
        int carID = Integer.parseInt(s.nextLine());

        System.out.println("************************");
        Cars carToEdit = CarService.getCarByID(carID);
        if (carToEdit == null) {
            System.out.println("Car with ID " + carID + " not found.");
            return;
        }

        System.out.println("Editing car: " + carToEdit.getMake() + " " + carToEdit.getModel());


        System.out.print("Enter new make: ");
        String newMake = s.nextLine();

        System.out.print("Enter new model: ");
        String newModel = s.nextLine();

        int newYear;
        while (true) {
            try {
                System.out.print("Enter new year: ");
                newYear = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Please enter a valid number.");
            }
        }

        System.out.print("Enter new type: ");
        String newType = s.nextLine();

        boolean success = CarService.editCar(carID, newMake, newModel, newYear, newType);
        if (success) {
            System.out.println("Car updated successfully!");
        } else {
            System.out.println("Car with ID " + carID + " not found.");
        }
    }

    public static void searchCarMenu(Scanner s) {
        System.out.println("Search Car Menu");
        System.out.println("1 - Search by Car ID");
        System.out.println("2 - Search by Keyword (Make, Model, Type)");
        System.out.println("3 - Search by Status");
        System.out.print("Choose option (1-3): ");

        String option = s.nextLine();

        switch (option) {
            case "1" -> {
                System.out.print("Enter Car ID: ");
                try {
                    int id = Integer.parseInt(s.nextLine());
                    Cars car = CarService.getCarByID(id);
                    if (car != null) {
                        printCarDetails(car);
                    } else {
                        System.out.println("No car found with ID " + id);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID input.");
                }
            }
            case "2" -> {
                System.out.print("Enter keyword: ");
                String keyword = s.nextLine();
                List<Cars> results = CarService.searchCarsByKeyword(keyword);
                if (results.isEmpty()) {
                    System.out.println("No cars found matching \"" + keyword + "\"");
                } else {
                    System.out.println("Search results:");
                    for (Cars car : results) {
                        printCarSummary(car);
                    }
                }
            }
            case "3" -> {
                System.out.println("Select status to search by:");
                for (CarStatus status : CarStatus.values()) {
                    System.out.println(status.ordinal() + " - " + status);
                }

                int statusChoice = -1;
                while (true) {
                    try {
                        System.out.print("Enter choice: ");
                        statusChoice = Integer.parseInt(s.nextLine());
                        if (statusChoice >= 0 && statusChoice < CarStatus.values().length) {
                            break;
                        } else {
                            System.out.println("Invalid choice, try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input, try again.");
                    }
                }

                CarStatus selectedStatus = CarStatus.values()[statusChoice];
                List<Cars> results = CarService.searchCarsByStatus(selectedStatus);

                if (results.isEmpty()) {
                    System.out.println("No cars found with status " + selectedStatus);
                } else {
                    System.out.println("Cars with status " + selectedStatus + ":");
                    for (Cars car : results) {
                        printCarSummary(car);
                    }
                }
            }
            default -> System.out.println("Invalid option selected.");
        }
    }

    private static void printCarDetails(Cars car) {
        System.out.println("Car Details:");
        System.out.println("ID: " + car.getCarID());
        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        System.out.println("Type: " + car.getType());
        System.out.println("Status: " + car.getStatus());
    }

    private static void printCarSummary(Cars car) {
        System.out.println("[" + car.getCarID() + "] " + car.getMake() + " " + car.getModel() + " (" + car.getType() + ")");
    }
}
