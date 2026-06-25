import java.util.Scanner;

public class conditionalsLoops {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        //        Basic



//        Area Of Circle
        final float pi = 3.14f;
//        System.out.print("Enter the radius of the circle: ");
//        float radius1 = input.nextFloat();
//        double area1 = pi * (radius1 * radius1);
//        System.out.println("The area of the circle is " + area1);


//        Area Of Triangle
//        System.out.print("Enter the base of the triangle: ");
//        double base = input.nextDouble();
//        System.out.print("Enter the height of the triangle: ");
//        double height = input.nextDouble();
//        double area2 = 0.5 * (base * height);
//        System.out.println("The area of the triangle is " + area2);


//        Area of Rectangle
//        System.out.print("Enter the length of the rectangle: ");
//        double length = input.nextDouble();
//        System.out.print("Enter the width of the rectangle: ");
//        double width = input.nextDouble();
//        double area3 = length * width;
//        System.out.println("The area of the rectangle is " + area3);


//        Area Of Isosceles Triangle
//        System.out.print("Enter the area of the side of the isosceles triangle: ");
//        double a = input.nextDouble();
//        double area4 = 0.5 * (a * a);
//        System.out.println("The area of the side of the isosceles triangle is " + area4);


//        Area Of Parallelogram without height
//        System.out.print("A: ");
//        double a1 = input.nextDouble();
//        System.out.print("B: ");
//        double b1 = input.nextDouble();
//        System.out.print("Sin: ");
//        double sin = input.nextDouble();
//        double sinValue = Math.sin(sin);
//        System.out.println("Area of Parallelogram without height: " + (a1 * b1 * sinValue) + " sq.cm.");


//        Area Of Rhombus
//        System.out.print("Enter diagonals: ");
//        double diagonals1 = input.nextDouble();
//        double diagonals2 = input.nextDouble();
//        double area5 = (diagonals1 * diagonals2) / 2;
//        System.out.println("Area of rhombus: " + area5);


//        Area of an Equilateral Triangle
//        System.out.print("Enter the side: ");
//        double a3 = input.nextDouble();
//        double area6 = Math.sqrt(3)/4 * (a3 * a3);
//        System.out.println("The area of an equilateral triangle is " + area6);


//        Perimeter of Circle
//        System.out.print("Enter radius: ");
//        double radius2 = input.nextDouble();
//        double perimeter1 = 2 * pi * radius2;
//        System.out.println("The perimeter of the triangle is " + perimeter1);


//        Perimeter of Equilateral triangle
//        System.out.print("Enter the side: ");
//        double a2 = input.nextDouble();
//        double p1 = 3 * a2;
//        System.out.println("The perimeter of the equilateral triangle is " + p1);


//        Perimeter of Parallelogram
//        System.out.print("a: ");
//        double a4  = input.nextDouble();
//        System.out.print("b: ");
//        double b = input.nextDouble();
//        double p2 = 2 * (a + b);
//        System.out.println("The perimeter of parallelogram is " + p2);


//        Perimeter of Square
//        System.out.print("Enter all 4 sides: ");
//        double side1 =  input.nextDouble();
//        double side2 =  input.nextDouble();
//        double side3 =  input.nextDouble();
//        double side4 =  input.nextDouble();
//        double p3 = 4 * (side1 + side2 + side3 + side4);
//        System.out.println("Perimeter of square is " + p3);


//        Volume Of Cone
//        System.out.print("Enter radius: ");
//        double radius3 = input.nextDouble();
//        System.out.print("Enter height: ");
//        double height1 = input.nextDouble();
//        double v1 = 1/3 * (pi * (radius3 * radius3) * height1);
//        System.out.println("The volume of a cone is: " + v1);


//        Fibonacci Series
//        System.out.print("Enter number of terms: ");
//        long n =  input.nextInt();
//        long first = 0, second = 1;
//        if (n <= 0){
//            System.out.print("Please enter a positive number.");
//            return;
//        }
//        if (n >= 1){
//            System.out.print(first);
//        }
//        if (n >= 2){
//            System.out.print(", " + second);
//        }
//        for (int i = 3; i <= n; i++){
//            long next = first + second;
//            System.out.print(", " + next);
//            first = second;
//            second = next;
//        }


//        Subtract the Product and Sum of Digits of an Integer
//        System.out.print("Enter the number: ");
//        int num = input.nextInt();
//        int product = 1, sum = 0;
//        while (num > 0){
//            int digit = num % 10;
//            product *= digit;
//            sum += digit;
//            num /= 10;
//        }
//        int result = product - sum;
//        System.out.println(result);


//        Input a number and print all the factors of that number (use loops).
//        System.out.print("Enter a number: ");
//        int number = input.nextInt();
//        System.out.print("Factors: ");
//        for (int i = 1; i <= number; i++) {
//            if (number % i == 0) {
//                System.out.print(i + " ");
//            }
//        }


//        Take integer inputs till the user enters 0 and print the sum of all numbers (HINT: while loop)
//        System.out.print("Enter a number: ");
//        int n = input.nextInt();
//        int sum = 0;
//        while(n != 0){
//            sum += n;
//            System.out.print("Enter a number: ");
//            n = input.nextInt();
//        }
//        System.out.println("The sum is " + sum);


//        Take integer inputs till the user enters 0 and print the largest number from all.
//        System.out.print("Enter a number (0 to stop): ");
//        int num = input.nextInt();
//        int largest = num;
//        while(num != 0){
//            if (num > largest){
//                largest = num;
//            }
//            System.out.print("Enter a number (0 to stop): ");
//            num = input.nextInt();
//        }
//        System.out.println("The largest number is " + largest);



        // Intermediate



//        Factorial Program
//        System.out.print("Enter a number: ");
//        int num = input.nextInt();
//        long factorial = 1;
//        for (int i = 1; i <= num; i++) {
//            factorial *= i;
//        }
//        System.out.println("Factorial of " + num + " is " + factorial);


//        Electricity Bill
//        System.out.print("Enter number of units consumed: ");
//        int units = input.nextInt();
//        double billAmount = 0;
//        if (units <= 100) {
//            billAmount = units * 1.20;
//        } else if (units <= 300) {
//            // First 100 units at 1.20, remaining at 2.00
//            billAmount = (100 * 1.20) + ((units - 100) * 2.00);
//        } else {
//            // First 100 at 1.20, next 200 at 2.00, remaining at 3.00
//            billAmount = (100 * 1.20) + (200 * 2.00) + ((units - 300) * 3.00);
//        }
//        System.out.println("Total Electricity Bill: " + billAmount);


//        Calculate Average Of N Numbers
//        System.out.print("How many numbers?: ");
//        int numbers = input.nextInt();
//        double sum = 0;
//        for (int i = 1; i <= numbers; i++) {
//            System.out.print("Enter number " + i + ": ");
//            sum += input.nextDouble();
//        }
//        double average = sum / numbers;
//        System.out.println("Average = " + average);


//        Armstrong Number
//        System.out.print("Enter a number: ");
//        int n = input.nextInt();
//        int temp = n;
//        int digits = String.valueOf(n).length();
//        int r, sum = 0;
//        while(n>0){
//            r = n%10;
//            sum += Math.pow(r,digits);
//            n = n/10;
//        }
//        if(temp==sum)
//            System.out.println("It's an Armstrong number");
//        else
//            System.out.println("It's not an Armstrong number");


//        Reverse A String
//        System.out.print("Enter: ");
//        String original = input.nextLine();
//        String reversed = "";
//        for (int i = original.length() - 1; i >= 0; i--) {
//            reversed += original.charAt(i);
//        }
//        System.out.println(reversed);


//        Find if a number is palindrome or not
//        System.out.print("Enter a number: ");
//        int num = input.nextInt();
//        int original = num;
//        int r, reversed = 0;
//        while (num > 0){
//            r = num % 10;
//            reversed = reversed * 10 + r;
//            num /= 10;
//        }
//        if  (original == reversed){
//            System.out.print("The number is palindrome");
//        } else {
//            System.out.print("The number is not palindrome");
//        }


//        Java Program Vowel Or Consonant
//        System.out.print("Enter a character: ");
//        char ch = Character.toLowerCase(input.next().charAt(0));
//        if(ch > 'a' && ch < 'z'){
//            if(ch == 'a' || ch == 'e' || ch == 'i' ||  ch == 'o' || ch == 'u'){
//                System.out.println(ch + " is a vowel.");
//            } else {
//                System.out.println(ch + " is a consonant.");
//            }
//        }  else {
//            System.out.println("Invalid input. Please enter a letter.");
//        }


//        Perfect Number
//        System.out.print("Enter a number: ");
//        int num = input.nextInt();
//        if (num <= 1) System.out.print("Invalid input");
//        int sum = 1;
//        for (int i = 2; i * i <= num; i++) {
//            if (num % i == 0) {
//                sum += i;
//                if (i * i != num) {
//                    sum += num / i;
//                }
//            }
//        }
//        if (sum == num) System.out.println("It's a perfect number");
//        else System.out.println("It's not a perfect number");


//        Kunal is allowed to go out with his friends only on the even days of a given month. Write a program to count the number of days he can go out in the month of August.
//        int august = 31;
//        int count = 0;
//        for (int i = 1; i <= august; i++) {
//            if (i % 2 == 0){
//                count++;
//            }
//        }
//        System.out.println("The sum is " + count);


//        Write a program to print the sum of negative numbers, sum of positive even numbers and the sum of positive odd numbers from a list of numbers (N) entered by the user. The list terminates when the user enters a zero.
        int negativeSum = 0;
        int positiveEvenSum = 0;
        int positiveOddSum = 0;
        while (true){
            System.out.print("Enter a number (0 to stop): ");
            int number = input.nextInt();
            if (number == 0) break;
            else if (number < 0) negativeSum += number;
            else if (number % 2 == 0) positiveEvenSum += number;
            else positiveOddSum += number;
        }
        System.out.println("Sum of negative numbers: " + negativeSum);
        System.out.println("Sum of positive even numbers: " + positiveEvenSum);
        System.out.println("Sum of positive odd numbers: " + positiveOddSum);
    }
}
