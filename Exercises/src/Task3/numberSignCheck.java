package Task3;

import java.util.Scanner;

public class numberSignCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        int checker = input.nextInt();

        if (checker > 0) {
            System.out.println("Positive Number");
        } else if (checker < 0) {
            System.out.println("Negative Number");
        } else {
            System.out.println("Number is Zero");
        }
    }
}
