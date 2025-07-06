package utils;


import java.util.Scanner;

public class MainMenu {

    public static int getValidMenu(Scanner s) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("**************************");
            System.out.print("Select from the menu (0–7): ");
            String input = s.nextLine();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 0 && choice < 8) {
                    validInput = true;
                } else {
                    System.out.println("**************************");
                    System.out.println("Out of range — please enter a number between 0 and 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("**************************");
                System.out.println("Invalid input. Please enter a number between 0 and 7.");
            }
        }
        return choice;
    }
}
