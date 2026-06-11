package Task4;

import java.util.Scanner;
import java.util.Random;
public class numberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int guess = 0;

        int number = (int)(Math.random() * 100);
        while(guess != number){
            System.out.print("Guess a number between 1 and 100: ");
            guess = input.nextInt();
            if(guess == number){
                System.out.println("You guessed!");
                break;
            } else if(guess > number){
                System.out.println("Too high");
            } else{
                System.out.println("Too low");
            }
        }
    }
}
