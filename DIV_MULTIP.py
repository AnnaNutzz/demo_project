

class Calculator:
    """A class to perform multiplication and division operations on integers."""

    def multiply(self, a, b):
        """Multiplies two integers and returns the result."""
        return a * b

    def divide(self, a, b):
        """Divides two integers and returns the result. Handles division by zero."""
        try:
            return a / b
        except ZeroDivisionError:
            return "Error: Division by zero is not allowed."

# Example usage with user input
if __name__ == "__main__":
    # Create an instance of the Calculator class
    calc = Calculator()

    # Prompt user for operation choice
    print("Choose an operation:")
    print("1. Multiply")
    print("2. Divide")
    choice = input("Enter 1 or 2: ")

    # Get user input for numbers
    try:
        num1 = int(input("Enter the first integer: "))
        num2 = int(input("Enter the second integer: "))

        # Perform the chosen operation
        if choice == "1":
            result = calc.multiply(num1, num2)
            print(f"Multiplication: {num1} * {num2} = {result}")
        elif choice == "2":
            result = calc.divide(num1, num2)
            print(f"Division: {num1} / {num2} = {result}")
        else:
            print("Invalid choice! Please enter 1 or 2.")
    except ValueError:
        print("Error: Please enter valid integers.")