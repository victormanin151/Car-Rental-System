package customer;
import cars.Cars;

import static services.CarService.getCarByID;

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
        this.chosenCar = getCarByID(carID);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Cars getChosenCar() {
        return chosenCar;
    }

    public void setChosenCar(Cars chosenCar) {
        this.chosenCar = chosenCar;
    }
}
