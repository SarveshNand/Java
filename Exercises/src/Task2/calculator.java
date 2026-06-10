// Building a Calculator

package Task2;

import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number 1: ");
        int number1 = input.nextInt();

        System.out.print("Number 2: ");
        int number2 = input.nextInt();

        System.out.print("Operand: ");
        String operand = input.next();

        switch (operand) {
            case "+" -> {
                int number = number1 + number2;
                System.out.println(number);
            }
            case "-" -> {
                int number = number1 - number2;
                System.out.println(number);
            }
            case "*" -> {
                int number = number1 * number2;
                System.out.println(number);
            }
            case "/" -> {
                int number = number1 / number2;
                System.out.println(number);
            }
            default -> System.out.println("Invalid Input");
        }
    }
}
