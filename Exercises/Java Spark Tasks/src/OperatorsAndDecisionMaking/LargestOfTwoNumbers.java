package OperatorsAndDecisionMaking;

public class LargestOfTwoNumbers {
    static void main() {
        int num1 = 10;
        int num2 = 9;
        if (num1 > num2){
            System.out.println(num1 + " is greater");
        } else if (num2 > num1) {
            System.out.println(num2 + " is greater");
        } else {
            System.out.println("Both numbers are equal");
        }
    }
}
