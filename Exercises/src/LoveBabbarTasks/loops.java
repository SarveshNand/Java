package LoveBabbarTasks;

import java.util.Scanner;

public class loops {
    public static void main() {
        Scanner input = new Scanner(System.in);

//        1.Print numbers from 1 to 10 using for loop.
//        for (int i = 1; i <= 10; i++){
//            System.out.println(i);
//        }


//        2.Print numbers from 10 to 1 using while loop.
//        int i = 10;
//        while (i >= 1){
//            System.out.println(i);
//            i--;
//        }


//        3.Print first 5 even numbers using for loop.
//        for (int i = 1; i <= 10; i++){
//            if (i % 2 == 0){
//                System.out.println(i);
//            }
//        }
//        OR
//        for (int i = 2; i <= 10; i = i + 2){
//            System.out.println(i);
//        }


//        4.Print multiplication table of 7.
//        for (int i = 1; i <= 10; i++){
//            System.out.println(7 + " X " + i + " = " + 7*i);
//        }


//        5.Use do-while to print a menu at least once.
//        int choice;
//        do {
//            System.out.println("----- MENU -----");
//            System.out.println("1. Option 1");
//            System.out.println("2. Option 2");
//            System.out.println("3. Exit");
//            System.out.print("Enter your choice: ");
//
//            choice = input.nextInt();
//
//            switch (choice){
//                case 1:
//                    System.out.println("You selected Option 1.");
//                    break;
//                case 2:
//                    System.out.println("You selected Option 2.");
//                    break;
//                case 3:
//                    System.out.println("Exiting the program...");
//                    break;
//                default:
//                    System.out.println("Invalid Choice! Try again.");
//            }
//        } while (choice != 3);


//        6.Print sum of numbers from 1 to n.
//        int sum = 0;
//        System.out.print("Enter your number: ");
//        int n = input.nextInt();
//        for (int i = 0; i <= n; i++){
//            sum += i;
//        }
//        System.out.println("The sum of numbers: " + sum);


//        7.Print square pattern of size n using nested loops.
//        int n = input.nextInt();
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j <= n; j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//        8.Print only odd numbers from 1 to 20 using continue.
//        for (int i = 1; i <= 20; i++){
//            if (i % 2 == 0){
//                continue;
//            } else{
//                System.out.println(i);
//            }
//        }


//        9.Stop loop when value becomes 6 using break.
        int n = input.nextInt();
        for (int i = 1; i <= n; i++){
            if (i == 6){
                break;
            }
            System.out.println(i);
        }
    }
}
