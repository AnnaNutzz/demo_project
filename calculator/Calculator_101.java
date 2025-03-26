public class Addition {
    // Original integer addition
    public int add(int a, int b) {
        return a + b;
    }
    
    // String concatenation
    public String add(String a, String b) {
        return a + b;
    }
}

public class Subtraction {
    // Original integer subtraction
    public int subtract(int a, int b) {
        return a - b;
    }
    
    // String subtraction (removes first occurrence)
    public String subtract(String a, String b) {
        int index = a.indexOf(b);
        if (index != -1) {
            return a.substring(0, index) + a.substring(index + b.length());
        }
        return a;
    }
}

public class Calculator {
    // Original integer multiplication
    public int multiply(int a, int b) {
        return a * b;
    }
    
    // String multiplication (repetition)
    public String multiply(String a, int b) {
        if (b < 0) return "Error: Cannot multiply string by negative number";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < b; i++) {
            result.append(a);
        }
        return result.toString();
    }
    
    // Original integer division
    public String divide(int a, int b) {
        try {
            return String.valueOf((double) a / b);
        } catch (ArithmeticException e) {
            return "Error: Division by zero is not allowed.";
        }
    }
    
    // String division (returns substring of divided length)
    public String divide(String a, int b) {
        try {
            if (b == 0) return "Error: Division by zero is not allowed.";
            int newLength = a.length() / b;
            return a.substring(0, newLength);
        } catch (StringIndexOutOfBoundsException e) {
            return a; // Return original string if division results in invalid length
        }
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Addition addition = new Addition();
        Subtraction subtraction = new Subtraction();
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        
        // Numeric operations
        System.out.println("Numeric Operations:");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.println("\nNumeric Results:");
        System.out.println("Add: " + addition.add(num1, num2));
        System.out.println("Subtract: " + subtraction.subtract(num1, num2));
        System.out.println("Multiply: " + calculator.multiply(num1, num2));
        System.out.println("Divide: " + calculator.divide(num1, num2));
        
        // Clear scanner buffer
        scanner.nextLine();
        
        // String operations
        System.out.println("\nString Operations:");
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second input (string for + and -, number for * and /): ");
        String input2 = scanner.nextLine();
        
        System.out.println("\nString Results:");
        // Addition (string + string)
        System.out.println("Add: " + addition.add(str1, input2));
        
        // Subtraction (string - string)
        System.out.println("Subtract: " + subtraction.subtract(str1, input2));
        
        // Multiplication and Division (string with number)
        try {
            int num = Integer.parseInt(input2);
            System.out.println("Multiply: " + calculator.multiply(str1, num));
            System.out.println("Divide: " + calculator.divide(str1, num));
        } catch (NumberFormatException e) {
            System.out.println("Multiply: Error - Second input must be a number");
            System.out.println("Divide: Error - Second input must be a number");
        }
        
        scanner.close();
    }
}
