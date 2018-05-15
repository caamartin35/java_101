package main.lecturecise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the vending machine!\n" +
            "You can type \'add <money in dollars>\' to insert money\n" +
            "You can type \'snacks\' to see the snack list\n" +
            "You can type \'details <snack name>\' to see the details of a snack\n" +
            "You can type \'vend <snack id>\' to get a snack\n" +
            "You can type \'exit\' to exit the vending machine.\n");
        VendingMachine vendingMachine = new VendingMachine();
        // This reads from system.in. When you print, you write to
        // System.out. see a pattern?
        Scanner reader = new Scanner(System.in);

        // This loop goes forever until exit is input.
        while (true) {
            System.out.println("You have inserted $0.00\n" +
                "What would you like to do?");
            String input = reader.nextLine();
            String command = input.split(" ")[0];
            if (command == null) {
                System.out.println("Invalid input.");
                continue;
            }
            if (command == "exit") {
                break;
            }

            switch (command) {
                case "add":
                    break;
                case "snacks":
                    break;
                default:
                    System.out.println("The vending machine didn\'t recognize your input!");
                    break;
            }

        }
        reader.close();
    }
}
