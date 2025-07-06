import java.util.Scanner;

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

            int choice = -1;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("**************************");
                System.out.print("Select from the menu (0–7): ");
                String input = s.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if(choice >= 0 && choice < 8){
                        validInput = true;
                    }
                } catch (NumberFormatException ignored) {
                    }

                    if (!validInput) {
                        System.out.println("**************************");
                        System.out.println("Invalid input — please enter a number between 0 and 7.");
                    }
            }

            switch (choice) {
//                case 1 ->
//                case 2 ->
//                case 3 ->
//                case 4 ->
//                case 5 ->
//                case 6 ->
                case 7 -> System.out.println("Remove a specific car (coming soon).");
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