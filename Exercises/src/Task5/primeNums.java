package Task5;

import java.util.Scanner;
public class primeNums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int start = input.nextInt();
        int end = input.nextInt();
        for (int i = start; i <= end; i++) {
            if(isPrime(i)){
                System.out.println(i + " ");
            }
        }
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
