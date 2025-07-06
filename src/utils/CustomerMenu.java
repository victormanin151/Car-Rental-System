package utils;
import cars.CarStatus;
import cars.Cars;
import customer.Customer;
import services.CarService;
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

        System.out.println("Enter start date:");
        String startDate = s.nextLine();

        System.out.println("Enter return date:");
        String returnDate = s.nextLine();

        Customer customer = new Customer(firstName, lastName, startDate, returnDate, carID);

        car.setRentedBy(customer);

        System.out.println("Car rented successfully to " + customer.getFullName());

        car.setRentedBy(customer);
        car.setStatus(CarStatus.BOOKED);
    }
}

