import services.CarService;
import utils.CarMenu;
import java.util.Scanner;
import static utils.MainMenu.getValidMenu;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean isRunning = true;


        while(isRunning){
            System.out.println("********************************");
            System.out.println("Welcome to the Car Rental System");
            System.out.println("********************************");
            System.out.println("Select from the menu below");
            System.out.println("**************************");
            System.out.println("1 - Add a new car.");
            System.out.println("2 - Rent a car.");
            System.out.println("3 - Edit a car.");
            System.out.println("4 - List all cars.");
            System.out.println("5 - Search for a specific car.");
            System.out.println("6 - Return a car.");
            System.out.println("7 - Remove a specific car.");
            System.out.println("0 - Save & Exit the program!");

            int choice = getValidMenu(s);

            switch (choice) {
                case 1 -> CarMenu.addCarMenu(s);
//                case 2 ->
//                case 3 ->
                case 4 -> CarService.listAllCars();
//                case 5 ->
                case 6 -> CarMenu.changeCarStatusMenu(s);
//                case 7 -> ;
                case 0 -> {
                    isRunning = false;
                    System.out.println("Saving and exiting the program...");
                }
            }

            System.out.println("**************************");
            System.out.println("Thank you for using Car Rental System!");
            System.out.println("Have a nice day!");
            System.out.println("**************************");
        }
        s.close();
    }
}