package services;

import cars.CarStatus;
import cars.Cars;
import customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarService {
    private static Map<Integer, Cars> carRegistry = new HashMap<>();
    private static final String CAR_DATA_FILE = "cars.csv";

    public static Cars addCar(String make, String model, int year, String type, CarStatus status) {
        Cars car = new Cars(make, model, year, type, status);
        carRegistry.put(car.getCarID(), car);
        return car;
    }

    public static Cars getCarByID(int id) {
        return carRegistry.get(id);
    }

    public static void listAllCars() {
        if (carRegistry.isEmpty()) {
            System.out.println("***********************");
            System.out.println("No cars in the system.");
        } else {
            System.out.println("***********************");
            System.out.println("------------- Car List -------------");
            System.out.println("ID | MAKE | MODEL | YEAR | TYPE | STATUS | RENTED BY");

            for (Cars car : carRegistry.values()) {
                String rentedBy = "";

                if (car.getStatus() == CarStatus.BOOKED && car.getRentedBy() != null) {
                    rentedBy = car.getRentedBy().getFullName();
                } else {
                    rentedBy = "—";
                }

                System.out.println("[" + car.getCarID() + "] " +
                        car.getMake() + " " +
                        car.getModel() + " " +
                        car.getYear() + " " +
                        car.getType() + " " +
                        car.getStatus() + " | " +
                        rentedBy);
            }
        }
    }

    public static boolean updateCarStatus(int carID, CarStatus newStatus) {
        Cars car = carRegistry.get(carID);
        if (car == null) return false;
        car.setStatus(newStatus);
        saveCarsToFile();
        return true;
    }

    public static boolean editCar(int carID, String newMake, String newModel, int newYear, String newType) {
        Cars car = carRegistry.get(carID);
        if (car == null) return false;

        car.setMake(newMake);
        car.setModel(newModel);
        car.setYear(newYear);
        car.setType(newType);
        saveCarsToFile();

        return true;
    }

    public static List<Cars> searchCarsByKeyword(String keyword) {
        List<Cars> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Cars car : carRegistry.values()) {
            if (car.getMake().toLowerCase().contains(lowerKeyword)
                    || car.getModel().toLowerCase().contains(lowerKeyword)
                    || car.getType().toLowerCase().contains(lowerKeyword)) {
                results.add(car);
            }
        }

        return results;
    }

    public static List<Cars> searchCarsByStatus(CarStatus status) {
        List<Cars> results = new ArrayList<>();
        for (Cars car : carRegistry.values()) {
            if (car.getStatus() == status) {
                results.add(car);
            }
        }
        return results;
    }

    public static void appendCarToFile(Cars car) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAR_DATA_FILE, true))) {
            String rentedBy = car.getRentedBy() != null ? car.getRentedBy().getFullName() : "";
            writer.println(car.getCarID() + "," +
                    car.getMake() + "," +
                    car.getModel() + "," +
                    car.getYear() + "," +
                    car.getType() + "," +
                    car.getStatus() + "," +
                    rentedBy);
        } catch (IOException e) {
            System.out.println("Error appending car to file: " + e.getMessage());
        }
    }

    public static void saveCarsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAR_DATA_FILE))) {
            for (Cars car : carRegistry.values()) {
                String rentedBy = car.getRentedBy() != null ? car.getRentedBy().getFullName() : "";
                String startedDate = car.getRentedBy() != null ? car.getRentedBy().getStartDate() : "";
                String returnDate = car.getRentedBy() != null ? car.getRentedBy().getReturnDate() : "";
                writer.println(car.getCarID() + "," +
                        car.getMake() + "," +
                        car.getModel() + "," +
                        car.getYear() + "," +
                        car.getType() + "," +
                        car.getStatus() + "," +
                        rentedBy + "," +
                        startedDate + "," +
                        returnDate);
            }
        } catch (IOException e) {
            System.out.println("Error saving cars to file: " + e.getMessage());
        }
    }


    public static void loadCarsFromFile() {
        File file = new File(CAR_DATA_FILE);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    int id = Integer.parseInt(parts[0].trim());
                    String make = parts[1].trim();
                    String model = parts[2].trim();
                    int year = Integer.parseInt(parts[3].trim());
                    String type = parts[4].trim();
                    CarStatus status = CarStatus.valueOf(parts[5].trim());

                    String rentedBy = parts.length >= 7 ? parts[6].trim() : "";
                    Cars car = new Cars(make, model, year, type, status);
                    if(!"".equals(rentedBy)){
                        String[] fullName = rentedBy.split(" ");

                        Customer customer = new Customer(fullName[0], fullName[1], parts[7], parts[8], id);
                        car.setRentedBy(customer);
                    }

                    car.setCarID(id);
                    carRegistry.put(id, car);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading cars from file: " + e.getMessage());
        }
    }
}
