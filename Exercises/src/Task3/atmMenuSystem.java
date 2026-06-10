package Task3;

import java.util.Scanner;
public class atmMenuSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance = 1000.0;
        System.out.println("\n===== ATM MENU =====");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Your balance: " + balance);
                break;
            case 2:
                System.out.println("Enter amount to deposit: ");
                double deposit = input.nextDouble();
                balance += deposit;
                System.out.println("Your balance: " + balance);
                break;
            case 3:
                System.out.println("Enter amount to withdraw: ");
                double withdraw = input.nextDouble();
                balance -= withdraw;
                System.out.println("Your balance: " + balance);
                break;
            case 4:
                System.out.println("Thank you for using your account!");
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
