// Calculate age from birth year

package Task1;

import java.util.Scanner;
public class birthToAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your Birth Year: ");
        int birthYear = scanner.nextInt();

        int age = 2026 - birthYear;
        System.out.println("Your Age is " + age);

        scanner.close();
    }
}
