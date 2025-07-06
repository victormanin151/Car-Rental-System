package services;

import cars.CarStatus;
import cars.Cars;

import java.util.HashMap;
import java.util.Map;

public class CarService {
    private static Map<Integer, Cars> carRegistry = new HashMap<>();

    public static void addCar(String make, String model, int year, String type, CarStatus status) {
        Cars car = new Cars(make, model, year, type, status);
        carRegistry.put(car.getCarID(), car);
    }

    public static Cars getCarByID(int id) {
        return carRegistry.get(id);
    }

    public static void listAllCars() {
        if (carRegistry.isEmpty()) {
            System.out.println("***********************");
            System.out.println("No cars in the system.");
        } else {
            for (Cars car : carRegistry.values()) {
                System.out.println("***********************");
                System.out.println("----------------- Car List -----------------");
                System.out.println("Car ID / MAKE / MODEL / YEAR / TYPE / STATUS");
                System.out.println("[" + car.getCarID() + "] " + car.getMake() + " " + car.getModel() + " " + car.getYear()
                + " " + car.getType() + " " + car.getStatus());
            }
        }
    }

    public static boolean updateCarStatus(int carID, CarStatus newStatus) {
        Cars car = carRegistry.get(carID);
        if (car == null) return false;
        car.setStatus(newStatus);
        return true;
    }

    public static boolean editCar(int carID, String newMake, String newModel, int newYear, String newType) {
        Cars car = carRegistry.get(carID);
        if (car == null) return false;

        car.setMake(newMake);
        car.setModel(newModel);
        car.setYear(newYear);
        car.setType(newType);

        return true;
    }

}
