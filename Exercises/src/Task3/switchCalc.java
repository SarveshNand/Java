package Task3;

import  java.util.Scanner;

public class switchCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter two numbers: ");
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.print("Enter operand: ");
        String op  = input.next();

        switch (op) {
            case "+":
                int  sum = a + b;
                System.out.println("Result: " + sum);
                break;
            case  "-":
                int  sub = a - b;
                System.out.println("Result: " + sub);
                break;
            case  "*":
                int  mul = a * b;
                System.out.println("Result: " + mul);
                break;
            case   "/":
                double  div = (double) a / b;
                System.out.println("Result: " + div);
                break;
        }
    }
}
