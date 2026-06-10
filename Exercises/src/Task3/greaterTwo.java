package Task3;

import java.util.Scanner;
public class greaterTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        int a = input.nextInt();
        int b = input.nextInt();
        if (a>b){
            System.out.println(a + " is greater");
        } else if (a < b) {
            System.out.println(b + " is greater");
        } else {
            System.out.println("both are same");
        }
    }
}
