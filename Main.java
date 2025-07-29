// PARTNER NAME: Adam Szloboda
// PARTNER NAME: 
// CS111 SECTION #:1602
// DATE:07/29/2025

import java.util.Scanner;

public class Main {

    /**
     * ALGORITHM:
     * - Add total funds to taco stand
     * - Order supplies
     * - Print status of stand (when it opens)
     * - Print welcome message
     * - Take customer order
     * - Print status of stand (when its closed)
     */
    public static void main(String[] args) {
        TacoStand.initialize();

        TacoStand.addTotalFunds(20);
        TacoStand.orderSupplies(15);

        System.out.println("OPENING UP THE STAND...");
        System.out.println(TacoStand.getStatus() + "\n\n");

        printWelcome();
        System.out.println("\n");

        takeOrder();

        System.out.println("--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
    }

    /**
     * Outputs welcome message to start program that user sees
     */
    public static void printWelcome() {
        UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
        UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
        UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
        UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
        UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
        UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
        UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
    }

    /**
     * Prompts user for taco order and checks inventory
     */
    public static void takeOrder() {
        int option, numTacosOrdered;

        TacoStand.printMenu();
        option = UtilityBelt.readInt("Enter choice> ", 1, 4);
        numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);

        if (TacoStand.areTacosAvailable(option, numTacosOrdered)) {
            TacoStand.updateTotalFunds(option, numTacosOrdered);
            printConfirmation(numTacosOrdered);
        } else {
            System.out.println("We don't have that many tacos, sorry! Try again :(");
        }
    }

    /**
     * Prints confirmation with taco emojis
     */
    public static void printConfirmation(int numTacos) {
        System.out.println("Here you go, buen provecho!");
        for (int i = 0; i < numTacos; i++) {
            System.out.print("🌮");
        }
        System.out.println();
    }
}
