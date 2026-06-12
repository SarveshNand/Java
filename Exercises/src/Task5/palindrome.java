package Task5;

import java.util.Scanner;
public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        if (num == reverse(num)) {
            System.out.println("The palindrome is a number");
        }  else {
            System.out.println("The palindrome is not a number");
        }
    }

    static int reverse(int n){
        int rev = 0;
        int rem = 0;
        while(n!=0){
            rem = n%10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev;
    }
}
