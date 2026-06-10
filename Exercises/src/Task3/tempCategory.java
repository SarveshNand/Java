package Task3;

import java.util.Scanner;
public class tempCategory {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the temperature: ");

        int temperature = input.nextInt();
        if (temperature < 10) {
            System.out.println("Very Cold");
        } else if (temperature >= 10 && temperature < 25) {
            System.out.println("Moderate");
        } else {
            System.out.println("Hot");
        }
    }
}
