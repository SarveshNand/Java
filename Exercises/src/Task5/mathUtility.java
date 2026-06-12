package Task5;

import java.util.Scanner;
public class mathUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("\n=== Math Utility Menu ===");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Square Root");
            System.out.println("6. Power");
            System.out.println("7. Factorial");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter two numbers: ");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    System.out.println("Result: " + addition(a, b));
                    break;
                case 2:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result = " + subtraction(a, b));
                    break;

                case 3:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result = " + multiplication(a, b));
                    break;

                case 4:
                    System.out.print("Enter two numbers: ");
                    a = sc.nextDouble();
                    b = sc.nextDouble();
                    System.out.println("Result = " + division(a, b));
                    break;

                case 5:
                    System.out.print("Enter a number: ");
                    double n = sc.nextDouble();
                    System.out.println("Square Root = " + squareRoot(n));
                    break;

                case 6:
                    System.out.print("Enter base and exponent: ");
                    double base = sc.nextDouble();
                    double exp = sc.nextDouble();
                    System.out.println("Result = " + power(base, exp));
                    break;

                case 7:
                    System.out.print("Enter an integer: ");
                    int num = sc.nextInt();
                    System.out.println("Factorial = " + factorial(num));
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static double addition(double a, double b){
        return a+b;
    }
    static double subtraction(double a, double b){
        return a-b;
    }
    static double multiplication(double a, double b){
        return a*b;
    }
    static double division(double a, double b){
        if(b==0){
            System.out.println("Cannot divide by zero");
            return 0;
        }
        return a/b;
    }
    static double squareRoot(double n){
        return Math.sqrt(n);
    }
    static double power(double base, double exponent){
        return Math.pow(base,exponent);
    }
    static long factorial(long n){
        long fact = 1;
        for(long i=1; i<=n; i++){
            fact *= i;
        }
        return fact;
    }
}