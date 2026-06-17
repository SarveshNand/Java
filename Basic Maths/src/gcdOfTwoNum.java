import java.util.Scanner;
public class gcdOfTwoNum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        int gcd = 1;

        for(int i = 1; i <= Math.min(num1, num2); i++){
            if(num1 % i == 0 && num2 % i == 0){
                gcd = i;
            }
        }
        System.out.println("The gcd of " + num1 + " and " + num2 + " is " + gcd);
    }
}
