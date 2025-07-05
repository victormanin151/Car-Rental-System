package customer;
import cars.Cars;

public class Customer {
    private String firstName;
    private String lastName;
    private String userName;
    private String startDate;
    private String returnDate;
    private Cars chosenCar;

    public Customer(String firstName, String lastName, String userName,
                    String startDate, String returnDate, int carID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.chosenCar = Cars.getCarByID(carID);
    }
}
