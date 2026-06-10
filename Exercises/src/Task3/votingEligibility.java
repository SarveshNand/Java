package Task3;

import java.util.Scanner;
public class votingEligibility {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if (age >= 18) {
            System.out.println("Eligible to vote");
        } else  {
            System.out.println("Not Eligible to vote");
        }
    }
}
