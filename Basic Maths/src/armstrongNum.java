import java.util.Scanner;

public class armstrongNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int original = n;
        int temp = n;
        int digits = 0;

        // Count digits
        while (temp > 0) {
            digits++;
            temp /= 10;
        }

        temp = n;
        int sum = 0;

        // Calculate sum of digits raised to power 'digits'
        while (temp > 0) {
            int digit = temp % 10;
            sum += (int) Math.pow(digit, digits);
            temp /= 10;
        }

        if (sum == original) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}