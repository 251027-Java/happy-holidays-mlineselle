import java.util.Scanner;

/**
 * Holiday ASCII Art Generator
 * 
 * Your task: Create a festive Christmas tree using ASCII characters!
 * 
 * Basic tree structure:
 * * <- Star on top
 * *** <- Tree branches (odd numbers of *)
 * *****
 * *******
 * ||| <- Trunk
 */
public class HolidayArt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Holiday ASCII Art Generator!");
        boolean validInput = false;
        int height = 0;
        while (!validInput) {
            System.out.print("Enter the height of the tree: ");
            try {
                height = scanner.nextInt();
                if (height > 0) {
                    validInput = true;
                } else {
                    System.out.println("Height must be a positive integer.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input.");
            }
        }

        printTree(height);
    }

    /**
     * Prints a Christmas tree with the given height.
     * 
     * @param height Number of branch levels (not including star and trunk)
     */
    public static void printTree(int height) {
        int width = height * 2 - 1;
        System.out.print(" ".repeat((width - 1) / 2));
        System.out.println('\u2606');
        for (int i = 1; i < height; i++) {
            int stars = i * 2 - 1;
            int spaces = (width - stars - 1) / 2;
            // Print spaces
            System.out.print(" ".repeat(spaces));
            // Print first star
            System.out.print("*");
            boolean lastWasDecoration = false;
            // Print middle stars with decorations
            for (int j = 0; j < stars; j++) {
                if (!lastWasDecoration && Math.random() < 0.2) {
                    System.out.print("o"); // Ornament
                    lastWasDecoration = true;
                } else if (!lastWasDecoration && Math.random() < 0.4) {
                    System.out.print("+"); // Tinsel
                    lastWasDecoration = true;
                } else {
                    System.out.print("*"); // Regular branch
                    lastWasDecoration = false;
                }
            }
            // Print last start
            System.out.println("*");
        }
        if (height > 3) {
            System.out.println(" ".repeat((width - 3) / 2) + "|||");
        } else {
            System.out.println(" ".repeat((width - 1) / 2) + "|");
        }

        System.out.println("\nHappy Holidays!");

    }
}
