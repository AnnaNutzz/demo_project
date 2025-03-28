public class Subtraction {
    // Method for subtracting two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method for removing the second string occurrence from the first
    public String subtract(String mainStr, String subStr) {
        return mainStr.replace(subStr, "");  // Removes all occurrences
    }
}
