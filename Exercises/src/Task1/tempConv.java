// Temperature conversion (C ↔ F)

package Task1;

import java.util.Scanner;
public class tempConv {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Celsius();
        Fahrenheit();
    }

    public static void Celsius(){
        System.out.print("Enter the Fahrenheit: ");
        double fahrenheit = sc.nextDouble();
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.println("°C = " + celsius);
    }

    public static void Fahrenheit(){
        System.out.print("Enter the Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 1.8) + 32;
        System.out.println("°F = " + fahrenheit);
    }
}
