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
            System.out.println("No cars in the system.");
        } else {
            for (Cars car : carRegistry.values()) {
                System.out.println("[" + car.getCarID() + "] " + car.getMake() + " " + car.getModel());
            }
        }
    }

}
