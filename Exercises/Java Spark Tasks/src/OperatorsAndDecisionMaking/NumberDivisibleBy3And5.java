package OperatorsAndDecisionMaking;

public class NumberDivisibleBy3And5 {
    public static void main(String[] args){
        int number = 30;

        if (number % 3 == 0 && number % 5 == 0) {
            System.out.println("Divisible by both 3 and 5");
        } else if (number % 3 == 0) {
            System.out.println("Divisible only by 3");
        } else if (number % 5 == 0) {
            System.out.println("Divisible only by 5");
        } else {
            System.out.println("Not divisible by 3 or 5");
        }
    }
}
