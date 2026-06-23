import java.util.Scanner;

public class firstJava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


//       1) Write a program to print whether a number is even or odd, also take input from the user.
        System.out.print("Enter a number: ");
        int num =  input.nextInt();

        if (num % 2 == 0){
            System.out.print("The number is even.");
        } else {
            System.out.print("The number is odd.");
        }



//       2) Take name as input and print a greeting message for that particular name.
        System.out.print("Enter a name: ");
        String name = input.next();

        System.out.print("Hello " + name + " how are you!!!");



//       3) Write a program to input principal, time, and rate (P, T, R) from the user and find Simple Interest.
        System.out.print("Enter Principal(P): ");
        double principal = input.nextDouble();
        System.out.print("Enter Time(T): ");
        double time = input.nextDouble();
        System.out.print("Enter Rate(R): ");
        double rate = input.nextDouble();

        double simpleInterest = (principal * time * rate) / 100;
        System.out.print("The Simple Interest is " + simpleInterest);



//       4) Take in two numbers and an operator (+, -, *, /) and calculate the value. (Use if conditions)
        int result = 0;
        System.out.print("Enter first number: ");
        int first = input.nextInt();
        System.out.print("Enter second number: ");
        int second = input.nextInt();
        System.out.println("Enter an operator: ");
        String operator = input.next();

        if (operator.equals("+")) {
            result  = first + second;
        } else if (operator.equals("-")) {
            result  = first - second;
        }  else if (operator.equals("*")) {
            result  = first * second;
        }  else if (operator.equals("/")) {
            if (second != 0){
                result  = first / second;
            } else {
                System.out.print("Cannot divide by zero");
            }
        } else {
            System.out.print("Invalid operator");
        }
        System.out.println(result);



//        5) Take 2 numbers as input and print the largest number.
        System.out.print("Enter two numbers: ");
        int firstTwo = input.nextInt();
        int secondTwo = input.nextInt();

        if (firstTwo > secondTwo){
            System.out.print("The Largest number is " + firstTwo);
        } else if (secondTwo > firstTwo){
            System.out.print("The Largest number is " + secondTwo);
        } else {
            System.out.print("Both are equal.");
        }



//        6) Input currency in rupees and output in USD.
        System.out.print("Enter currency in INR(₹): ");
        double inr =  input.nextDouble();
        double usd =  inr * 0.011;
        System.out.print("The USD($) will be: " + usd);



//        7) To calculate Fibonacci Series up to n numbers.
        int firstNum = 0, secondNum = 1;
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= number; i++){
            System.out.print(firstNum + " ");
            int next = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = next;
        }



//        8) To find out whether the given String is Palindrome or not.
        System.out.print("Enter a string: ");
        String original = input.next();
        boolean isPalindrome = true;

        int left = 0;
        int right = original.length() - 1;

        while (left < right){
            if (original.charAt(left) != original.charAt(right)){
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        if (isPalindrome){
            System.out.print(original + " is a palindrome.");
        } else {
            System.out.print(original + " is not a palindrome.");
        }



//        9) To find Armstrong Number between two given number.
        System.out.print("Enter the starting number: ");
        int start = input.nextInt();
        System.out.print("Enter the ending number: ");
        int end = input.nextInt();
        System.out.print("Armstrong numbers between " + start + " and " + end + ": ");
        for (int i = start; i <= end; i++){
            int originalNum = i;
            int sum = 0;
            int digits = 0;
            int temp = num;

            if (temp == 0){
                digits = 1;
            } else {
                while (temp != 0){
                    temp /= 10;
                    digits++;
                }
            }
            temp = num;
            while (temp != 0){
                int remainder = temp % 10;
                int powerResult = 1;
                for (int j = 0; j < digits; j++) {
                    powerResult = powerResult * remainder;
                }
                sum = sum + powerResult;
                temp = temp / 10;
            }
            if (sum == originalNum) {
                System.out.print(originalNum + " ");
            }
        }
    }
}
