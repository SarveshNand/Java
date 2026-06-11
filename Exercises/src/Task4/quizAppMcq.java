package Task4;

import java.util.Scanner;

public class quizAppMcq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = 0;
        int questionNumber = 1;

        while (questionNumber <= 3) {

            if (questionNumber == 1) {
                System.out.println("1. What is the capital of India?");
                System.out.println("A. Mumbai");
                System.out.println("B. New Delhi");
                System.out.println("C. Kolkata");
                System.out.println("D. Chennai");

                System.out.print("Enter your answer: ");
                char answer = Character.toUpperCase(sc.next().charAt(0));

                if (answer == 'B') {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer is B.\n");
                }
            }

            else if (questionNumber == 2) {
                System.out.println("2. Which language is used for Android development?");
                System.out.println("A. Java");
                System.out.println("B. Python");
                System.out.println("C. C++");
                System.out.println("D. PHP");

                System.out.print("Enter your answer: ");
                char answer = Character.toUpperCase(sc.next().charAt(0));

                if (answer == 'A') {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer is A.\n");
                }
            }

            else if (questionNumber == 3) {
                System.out.println("3. How many days are there in a week?");
                System.out.println("A. 5");
                System.out.println("B. 6");
                System.out.println("C. 7");
                System.out.println("D. 8");

                System.out.print("Enter your answer: ");
                char answer = Character.toUpperCase(sc.next().charAt(0));

                if (answer == 'C') {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! Correct answer is C.\n");
                }
            }

            questionNumber++;
        }

        System.out.println("Quiz Finished!");
        System.out.println("Your Score: " + score + "/3");

        if (score == 3) {
            System.out.println("Excellent!");
        } else if (score >= 2) {
            System.out.println("Good Job!");
        } else {
            System.out.println("Keep Practicing!");
        }

        sc.close();
    }
}
