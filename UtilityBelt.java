import java.util.Scanner;

public class UtilityBelt {
    private static final Scanner input = new Scanner(System.in);

    /**
     * Prints a string centered based on console width
     */
    public static void printCentered(int width, String message) {
        int leftPadding = (width - message.length()) / 2;
        for (int i = 0; i < leftPadding; i++) System.out.print(" ");
        System.out.println(message);
    }

    /**
     * Read an integer in a given range
     */
    public static int readInt(String prompt, int min, int max) {
        int num;
        while (true) {
            System.out.print(prompt);
            if (input.hasNextInt()) {
                num = input.nextInt();
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("Invalid input, please enter between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // clear invalid input
            }
        }
    }
}
