package Task3;

import java.util.Scanner;
public class largestThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();

        if (a > b && a > c) {
            System.out.println("Output: Largest number is " + a);
        } else if (b > a && b > c) {
            System.out.println("Output: Largest number is " + b);
        }  else if (c > a && c > b) {
            System.out.println("Output: Largest number is " + c);
        } else {
            System.out.println("All three numbers are equal");
        }
    }
}
