package utils;
import cars.CarStatus;
import cars.Cars;
import customer.Customer;
import services.CarService;
import services.DateValidator;

import java.util.Scanner;

public class CustomerMenu {
    public static void rentCarMenu(Scanner s) {

        System.out.println("Enter Car ID to rent:");
        int carID = Integer.parseInt(s.nextLine());

        Cars car = CarService.getCarByID(carID);

        if (car == null) {
            System.out.println("Car not found.");
            return;
        }

        if (car.isRented()) {
            System.out.println("Car is already rented by: " + car.getRentedBy().getFullName());
            return;
        }

        System.out.println("Enter first name:");
        String firstName = s.nextLine();

        System.out.println("Enter last name:");
        String lastName = s.nextLine();

        String startDate, returnDate;

        while (true) {
            System.out.println("Enter start date (dd/MM/yyyy): ");
            startDate = s.nextLine();

            System.out.println("Enter end date (dd/MM/yyyy): ");
            returnDate = s.nextLine();

            if (DateValidator.isValidRentalPeriod(startDate, returnDate)) {
                break;
            } else {
                System.out.println("Invalid rental period. Please try again.");
            }
        }

        Customer customer = new Customer(firstName, lastName, startDate, returnDate, carID);

        System.out.println("Car rented successfully to " + customer.getFullName());

        car.setRentedBy(customer);
        car.setStatus(CarStatus.BOOKED);
    }
}

