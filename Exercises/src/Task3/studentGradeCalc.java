package Task3;

import  java.util.Scanner;
public class studentGradeCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input: ");
        int grade = input.nextInt();

        if (grade >= 90) {
            System.out.println("Grade A");
        } else if (grade >= 75) {
            System.out.println("Grade B");
        } else if (grade >= 60) {
            System.out.println("Grade C");
        } else if (grade >= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Fail");
        }
    }
}