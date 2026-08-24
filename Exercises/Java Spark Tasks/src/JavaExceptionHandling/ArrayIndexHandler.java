package JavaExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayIndexHandler {

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 23, 56};
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        try {
            System.out.println("Enter an index(0-4): ");
            int index = scanner.nextInt();
            System.out.println("Value: " + arr[index]);
        } catch (InputMismatchException e){
            System.out.println("Please enter an Integer.");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index. Please enter a value between 0 and 4.");
        } finally {
            scanner.close();
            System.out.println("Scanner closed.");
        }
    }
}
