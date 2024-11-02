import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double lastResult = 0;
        ArrayList<Double> results = new ArrayList<>();
        double number1;
        double number2;

            int choice;
            do {
                System.out.println("\nChoose an operation:" +
                        "\n1. Add numbers" +
                        "\n2. Subtract numbers" +
                        "\n3. Multiply numbers" +
                        "\n4. Divide numbers" +
                        "\n5. Modulus of numbers" +
                        "\n6. Find minimum number" +
                        "\n7. Find maximum number" +
                        "\n8. Find average of numbers" +
                        "\n9. Print last result" +
                        "\n10. Print all results" +
                        "\n0. Exit program");

                choice = input.nextInt();

                if (choice==10){
                    System.out.println("All results: "+results);
                    break;
                }
                if (choice==9){
                    System.out.println("Last result: " + lastResult);
                    break;
                }

                System.out.println("Enter first number : ");
                number1=input.nextDouble();
                System.out.println("Enter second number ");
                number2=input.nextDouble();



                switch (choice) {
                    case 1:
                        lastResult = add(number1, number2);
                        break;
                    case 2:
                        lastResult = subtract(number1, number2);
                        break;
                    case 3:
                        lastResult = multiply(number1, number2);
                        break;
                    case 4:
                        lastResult = divide(number1, number2);
                        break;
                    case 5:
                        lastResult = modulus(number1, number2);
                        break;
                    case 6:
                        lastResult = min(number1, number2);
                        break;
                    case 7:
                        lastResult = max(number1, number2);
                        break;
                    case 8:
                        lastResult = average(number1, number2);
                        break;
                }

                results.add(lastResult);
                System.out.println("Result: " + lastResult);

            } while (choice != 0);
            System.out.println("Program terminated.");
        }


        public static double add(double a, double b) {
            return a + b;
        }

        public static double subtract(double a, double b) {
            return a - b;
        }

        public static double multiply(double a, double b) {
            return a * b;
        }

        private static double divide(double a, double b) {
            if (b != 0) {
                return a / b;
            } else {
                System.out.println("Error: Cannot divide by zero.");
                return 0;
            }
        }

        private static double modulus(double a, double b) {
            return a % b;
        }

        private static double min(double a, double b) {
        if (a>b)
            return b;
        else
            return a;
        }

        private static double max(double a, double b) {
            if (a>b)
                return a;
            else
                return b;
        }

        private static double average(double a, double b) {
            return (a + b) / 2;
        }

}