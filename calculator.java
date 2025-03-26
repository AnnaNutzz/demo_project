public class Main {
    public static void main(String[] args) {
        // Create instances of the operation classes
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Calculator calculator = new Calculator();
        
        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Get first number
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();
        
        // Get second number
        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        
        // Perform and display all operations
        System.out.println("\nResults:");
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + 
            addition.add(num1, num2));
        
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + 
            subtraction.subtract(num1, num2));
        
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + 
            calculator.multiply(num1, num2));
        
        System.out.println("Division: " + num1 + " / " + num2 + " = " + 
            calculator.divide(num1, num2));
        
        // Close the scanner
        scanner.close();
    }
}
