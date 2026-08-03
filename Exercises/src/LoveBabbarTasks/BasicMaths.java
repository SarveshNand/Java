package LoveBabbarTasks;

public class BasicMaths {

    static void main() {
//        System.out.println(digitCount(12345));
//        System.out.println(sumOfDigits(12345));
//        System.out.println(revNum(12345));
//        System.out.println(evenOdd(12345));
//        System.out.println(isPalindrome(121));
//        primeOrNot(121);
//        System.out.println(getGCD(12, 18));
//        System.out.println(getLCM(12, 18));
//        System.out.println(getFact(3));
//        System.out.println(getArmstrong(153));
//        System.out.println(numPower(2, 3));
//        System.out.println(checkPerfectNumber(6));
//        System.out.println(countEvenDigits(234));
        nPrime(7);
    }


//    Problem 1: Count Digits in a Number
    static int digitCount(int num) {
        int count = 0;
        while(num != 0){
            count++;
            num /= 10;
        }
        return count;
    }


//    Problem 2: Sum of Digits
    static int sumOfDigits(int num){
        int sum = 0;
        while (num != 0){
            int digit = num%10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }


//    Problem 3: Reverse a Number
    static int revNum(int num){
        int reverse = 0;
        while (num != 0){
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return reverse;
    }


//    4. Even and Odd Number
    static String evenOdd(int num){
        if (num % 2 == 0){
            return "Even";
        } else {
            return "Odd";
        }
    }


//    Problem 4: Palindrome Number
    static String isPalindrome(int num){
        if (num == revNum(num)){
            return "It is a Palindrome";
        } else {
            return "It is not a Palindrome";
        }
    }


//    Problem 5: Prime Number
    static void primeOrNot(int num){
        boolean isPrime =  true;
        if (num <= 1){
            isPrime = false;
        } else {
            for (int i = 2; i<=Math.sqrt(num); i++){
                if (num%i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        if (isPrime){
            System.out.println("It is a Prime number");
        } else {
            System.out.println("It is not a Prime number");
        }
    }


//    Problem 6: GCD (Greatest Common Divisor)
    static int getGCD(int a, int b){
        //gcd(a,b) = gcd(b,a%b);
        while (b!=0){
            int oldValueOfb = b;
            b=a%b;
            a=oldValueOfb;
        }
        int ans = a;
        return ans;
    }


//    Problem 7: LCM (Least Common Multiplier)
    static int getLCM(int a, int b){
        int gcd = getGCD(a , b);
        int prod = a*b;
        int lcm = prod/gcd;
        return lcm;
    }


//    8. Factorial
    static int getFact(int num){
        int fact = 1;
        for (int i = 1; i<=num; i++){
            fact *= i;
        }
        return fact;
    }


//    Problem 9: Armstrong Number
    static String getArmstrong(int num){
        int sum = 0;
        int original = num;
        while (num != 0){
            int digit = num%10;
            sum = sum + (digit * digit * digit);
            num /= 10;
        }
        if (sum == original){
            return "Armstrong number";
        } else {
            return "Not Armstrong number";
        }
    }


//    Problem 10: Power of a Number
    static int numPower(int a, int b){
        int ans = 1;
        for (int i = 1; i<=b; i++){
            ans = ans * a;
        }
        return ans;
    }


//    Problem 11: Perfect Number
    static boolean checkPerfectNumber(int num){
        int sum = 1;
        for (int i = 2; i*i<=num; i++){
            if (num%i==0){
                int firstFactor = i;
                int secondFactor = num/i;
                sum = sum + firstFactor + secondFactor;
            }
        }
        if (sum == num){
            return true;
        } else {
            return false;
        }
    }


//    Problem 12: Count Number of Even Digits
    static int countEvenDigits(int num){
        int count = 0;
        while (num != 0){
            int digit = num%10;
            if (digit % 2 == 0){
                count++;
            }
            num /= 10;
        }
        return count;
    }


//    Problem 13: Print All Prime Numbers from 1 to n
    static void nPrime(int num){
        for (int i = 2; i<=num; i++){
            boolean isPrime = true;
            for (int j = 2; j*j <= i; j++){
                if (i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                System.out.print(i + " ");
            }
        }
    }
}
