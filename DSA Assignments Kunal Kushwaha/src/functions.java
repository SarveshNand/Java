import java.util.Scanner;

public class functions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter three numbers: ");
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        int c = scanner.nextInt();
//        int maxNum = maxNumber(a, b, c);
//        int minNum = minNumber(a, b, c);
//        System.out.println("The maximum number is " + maxNum + " and the minimum number is " + minNum);

//        int isEvenOrOdd = evenOdd(scanner.nextInt());
//        if(isEvenOrOdd == 0) System.out.println("Even");
//        else System.out.println("Odd");

//        eligibleToVote(scanner.nextInt());

//        System.out.println("Sum: " + twoNumSum(scanner.nextInt(), scanner.nextInt()));

//        System.out.println("Product: " + twoNumProduct(scanner.nextInt(), scanner.nextInt()));

//        double[] result = circumAreaCircle(scanner.nextDouble());
//        System.out.println("Area = " + result[0]);
//        System.out.println("Circumference = " + result[1]);

//        boolean checkPrime = isPrime(scanner.nextInt());
//        if (checkPrime) System.out.println("Prime Number");
//        else System.out.println("Not Prime Number");

//        checkGrade(scanner.nextInt());

//        int checkFactorial = factorial(scanner.nextInt());
//        System.out.println(checkFactorial);

//        System.out.println(checkPalindrome(121));

//        System.out.println(sumOfNaturalNumbers(scanner.nextInt()));

//        printPrimes(10, 50);

        System.out.println(isPythagoreanTriplet(5, 12, 13));
    }


//    Define two methods to print the maximum and the minimum number respectively among three numbers entered by the user.
    static int maxNumber(int a, int b, int c){
        if(a>=b && a>=c) return a;
        else if(b>=a && b>=c) return b;
        else return c;
    }
    static int minNumber(int a, int b, int c){
        if(a<=b && a<=c) return a;
        else if(b<=a && b<=c) return b;
        else return c;
    }


//    Define a program to find out whether a given number is even or odd.
    static int evenOdd(int n){
        if(n%2==0) return 0;
        else return 1;
    }


//    A person is eligible to vote if his/her age is greater than or equal to 18. Define a method to find out if he/she is eligible to vote.
    static void eligibleToVote(int n){
        if (n>=18) System.out.print("Eligible to vote");
        else System.out.print("Not eligible to vote");
    }


//    Write a program to print the sum of two numbers entered by user by defining your own method.
    static int twoNumSum(int a, int b){
        int sum = a + b;
        return sum;
    }


//  Define a method that returns the product of two numbers entered by user.
    static int twoNumProduct(int a, int b){
        int product = a * b;
        return product;
    }


//    Write a program to print the circumference and area of a circle of radius entered by user by defining your own method.
    static double[] circumAreaCircle(double radius) {
        double circumference = 2 * Math.PI * radius;
        double area = Math.PI * radius * radius;
        return new double[]{area, circumference};
    }


//    Define a method to find out if a number is prime or not.
    static boolean isPrime(int n){
        if(n<=1) return false;
        if (n==2) return true;
        if(n%2==0) return false;
        for (int i=3; i*i<=n; i+=2){
            if(n%i==0) return false;
        }
        return true;
    }


//    Write a program that will ask the user to enter his/her marks (out of 100). Define a method that will display grades according to the marks entered as below:
    /*
        Marks        Grade
        91-100         AA
        81-90          AB
        71-80          BB
        61-70          BC
        51-60          CD
        41-50          DD
        <=40          Fail
    */

    static void checkGrade(int n){
        if (n>90 && n<100) System.out.print("AA");
        else if (n>80 && n<=90) System.out.print("AB");
        else if (n>70 && n<=80) System.out.print("BB");
        else if (n>60 && n<=70) System.out.print("BC");
        else if (n>50 &&  n<=60) System.out.print("CD");
        else if (n>40 &&  n<=50) System.out.print("DD");
        else System.out.print("Fail");
    }


//    Write a program to print the factorial of a number by defining a method named 'Factorial'. Factorial of any number n is represented by n! and is equal to 1 * 2 * 3 * .... * (n-1) *n. E.g.-
    /*
    4! = 1 * 2 * 3 * 4 = 24
    3! = 3 * 2 * 1 = 6
    2! = 2 * 1 = 2
    Also,
    1! = 1
    0! = 1
     */

    static int factorial(int n){
        if(n==0 || n==1) return 1;
        int fact = 1;
        for (int i=2; i<=n; i++){
            fact *= i;
        }
        return fact;
    }


//    Write a function to find if a number is a palindrome or not. Take number as parameter.
    static boolean checkPalindrome(int n){
        int rev = 0;
        int original = n;
        while(n!=0){
            int rem = n%10;
            rev = rev*10 + rem;
            n = n/10;
        }
        return original ==  rev;
    }


//    Write a function that returns the sum of first n natural numbers.
    static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }


//    Write a function that returns all prime numbers between two given numbers.
    static boolean isPrimeOrNot(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void printPrimes(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (isPrimeOrNot(i)) {
                System.out.print(i + " ");
            }
        }
    }


//    Write a function to check if a given triplet is a Pythagorean triplet or not. (A Pythagorean triplet is when the sum of the square of two numbers is equal to the square of the third number).
    static boolean isPythagoreanTriplet(int a, int b, int c) {
        // Find the largest number
        int max = Math.max(a, Math.max(b, c));
        if (max == a) {
            return (b * b + c * c) == (a * a);
        } else if (max == b) {
            return (a * a + c * c) == (b * b);
        } else {
            return (a * a + b * b) == (c * c);
        }
    }
}
