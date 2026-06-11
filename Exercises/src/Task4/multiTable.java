package Task4;

import java.util.Scanner;
public class multiTable {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = input.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= 10; j++){
                System.out.println(i + " * " + j + " = " + (i*j));
            }
            System.out.println();
        }
    }
}
