package utils;

import cars.CarStatus;
import cars.Cars;
import services.CarService;

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

        System.out.print("Enter type (e.g., Sedan, SUV, Truck): ");
        String type = s.nextLine();

        CarService.addCar(make, model, year, type, CarStatus.AVAILABLE);

        System.out.println("**************************");
        System.out.println("Car successfully added!");
    }
}
