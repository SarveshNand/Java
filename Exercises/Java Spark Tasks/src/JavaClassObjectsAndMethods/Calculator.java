package JavaClassObjectsAndMethods;

public class Calculator {

    // 1. No parameter and no return value
    void displayMessage() {
        System.out.println("Welcome to Calculator");
    }

    // 2. Parameters and no return value
    void add(int a, int b){
        System.out.println("Addition: " + (a+b));
    }

//    int add(int a, int b){
//        return a+b;
//    }

    int subtract(int a, int b){
        return a-b;
    }

    // 4. Parameters and a return value
    int multiply(int a, int b){
        return a*b;
    }
    double divide(double a, double b){
        return a/b;
    }

    // 3. No parameter and a return value
    int getNumber() {
        return 100;
    }
}
