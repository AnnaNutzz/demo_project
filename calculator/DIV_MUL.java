import java.util.Scanner;

public class Calculator {
    // Method to multiply two integers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two integers, returns a String to handle errors
    public String divide(int a, int b) {
        try {
            return String.valueOf((double) a / b); // Cast to double for decimal result
        } catch (ArithmeticException e) {
            return "Error: Division by zero is not allowed.";
        }
    }