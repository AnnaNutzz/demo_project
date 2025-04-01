import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Scanner;

public class AdvancedCalculator {
    // Custom JavaScript functions
    private static final String CUSTOM_FUNCTIONS = """
        function factorial(n) {
            if (n < 0 || n % 1 !== 0) return NaN;
            if (n === 0 || n === 1) return 1;
            return n * factorial(n - 1);
        }
        function combinations(n, k) {
            if (n < 0 || k < 0 || k > n || n % 1 !== 0 || k % 1 !== 0) return NaN;
            return factorial(n) / (factorial(k) * factorial(n - k));
        }
        function permutations(n, k) {
            if (n < 0 || k < 0 || k > n || n % 1 !== 0 || k % 1 !== 0) return NaN;
            return factorial(n) / factorial(n - k);
        }
        function mean(arr) {
            if (!Array.isArray(arr) || arr.length === 0) return NaN;
            var sum = 0;
            for (var i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            return sum / arr.length;
        }
        """;

    // Help message with updated instructions
    private static final String HELP_MESSAGE = """
        Advanced Calculator Help:
        - Type mathematical expressions to evaluate them (single-line mode).
        - Type 'multi' to enter multi-line mode; end with 'end' to evaluate.
        - Use JavaScript syntax for functions and operations.
        - Available functions:
          - Basic: +, -, *, /, ** (exponentiation)
          - Trigonometric: Math.sin(), Math.cos(), Math.tan(), etc. (angles in radians)
          - Logarithmic: Math.log() (natural log), Math.log10()
          - Exponential: Math.exp()
          - Constants: Math.PI, Math.E
          - Custom functions:
            - factorial(n): computes n! (e.g., factorial(5) = 120)
            - combinations(n, k): computes C(n, k)
            - permutations(n, k): computes P(n, k)
            - mean(arr): computes the mean of an array (e.g., mean([1,2,3]) = 2)
        - Define variables, e.g., x = 5
        - Last result is stored in 'ans'
        - Type 'help' to see this message
        - Type 'exit' or 'quit' to quit
        """;

    public static void main(String[] args) {
        // Initialize ScriptEngine
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        if (engine == null) {
            System.out.println("JavaScript engine not found.");
            return;
        }

        // Load custom functions
        try {
            engine.eval(CUSTOM_FUNCTIONS);
        } catch (ScriptException e) {
            System.out.println("Error initializing custom functions: " + e.getMessage());
            return;
        }

        // Set up scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Advanced Calculator. Type 'help' for instructions, 'exit' to quit.");

        // Main loop
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                break;
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println(HELP_MESSAGE);
            } else if (input.equalsIgnoreCase("multi")) {
                // Multi-line input mode
                System.out.println("Enter multi-line expression (type 'end' to evaluate):");
                StringBuilder multiLineInput = new StringBuilder();
                while (true) {
                    String line = scanner.nextLine().trim();
                    if (line.equalsIgnoreCase("end")) {
                        break;
                    }
                    multiLineInput.append(line).append("\n");
                }
                try {
                    Object result = engine.eval(multiLineInput.toString());
                    if (result != null) {
                        System.out.println(result);
                        engine.put("ans", result);
                    }
                } catch (ScriptException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                // Single-line evaluation
                try {
                    Object result = engine.eval(input);
                    if (result != null) {
                        System.out.println(result);
                        engine.put("ans", result);
                    }
                } catch (ScriptException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}