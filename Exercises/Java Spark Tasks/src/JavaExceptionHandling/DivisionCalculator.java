package JavaExceptionHandling;

public class DivisionCalculator {
    static void numbers(int num1, int num2){
        try{
            System.out.println(num1/num2);
        } catch (ArithmeticException e){
            System.out.println("Can't divide by 0");
        }
        System.out.println("Program completed");
    }

    public static void main(String[] args) {
        numbers(45, 0);
    }
}
