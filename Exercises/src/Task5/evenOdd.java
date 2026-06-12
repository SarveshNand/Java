package Task5;

import  java.util.Scanner;

public class evenOdd {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = input.nextInt();
        System.out.println(EvenOdd(number));
    }

    static String EvenOdd(int num){
        if(num%2==0){
            return "Even";
        }
        return "Odd";
    }
}
