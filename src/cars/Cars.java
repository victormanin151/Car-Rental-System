package cars;

public class Cars {
    private int carID;
    private static int uniqueID = 1;
    private String make;
    private String model;
    private int year;
    private String type;
    private CarStatus status;

    public Cars(String make, String model, int year, String type, CarStatus status){
        this.carID = uniqueID++;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.status = status;
    }

    public int getCarID() {
        return carID;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

}
