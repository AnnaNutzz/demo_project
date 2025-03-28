import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create instances of the operation classes
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Calculator calculator = new Calculator();

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Operation Type:");
        System.out.println("1 - Numeric Operations");
        System.out.println("2 - Textual Operations");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            // Numeric Operations
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();

            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            System.out.println("\nResults:");
            System.out.println("Addition: " + num1 + " + " + num2 + " = " + addition.add(num1, num2));
            System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + subtraction.subtract(num1, num2));
            System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + calculator.multiply(num1, num2));

            // Handling division by zero
            if (num2 != 0) {
                System.out.println("Division: " + num1 + " / " + num2 + " = " + calculator.divide(num1, num2));
            } else {
                System.out.println("Division: Cannot divide by zero!");
            }

        } else if (choice == 2) {
            // Textual Operations
            System.out.print("Enter the first text: ");
            String text1 = scanner.nextLine();

            System.out.print("Enter the second text: ");
            String text2 = scanner.nextLine();

            System.out.println("\nText Operations:");
            System.out.println("Concatenation: " + addition.add(text1, text2));
            System.out.println("Text Removal: " + subtraction.subtract(text1, text2));

        } else {
            System.out.println("Invalid choice! Please select 1 or 2.");
        }

        // Close the scanner
        scanner.close();
    }
}
