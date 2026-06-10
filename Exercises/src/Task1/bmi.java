// BMI Calculator

package Task1;

import java.util.Scanner;
public class bmi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in meters: ");
        double height = input.nextDouble();

        System.out.print("Enter your weight in kilograms: ");
        double weight = input.nextDouble();

        double bmi = weight / (height * height);
        System.out.println("Your BMI is: " + bmi);
    }
}
