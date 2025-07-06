import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean isRunning = true;
        int choice;


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
            System.out.println("6 - Remove a specific car.");
            System.out.println("0 - Exit the program!");
            System.out.println("*********************");
            System.out.print("Enter you choice (0-6): ");

            choice = Integer.parseInt(s.nextLine());


            switch (choice){
//                case 1 ->
//                case 2 ->
//                case 3 ->
//                case 4 ->
//                case 5 ->
//                case 6 ->
                case 0 -> isRunning = false;
                default -> System.out.println("Invalid choice");
            }

            System.out.println("**************************");
            System.out.println("Thank you! Have a nice day!");
            System.out.println("**************************");

            s.close();
        }
    }
}