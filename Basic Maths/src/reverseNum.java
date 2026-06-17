import java.util.Scanner;

public class reverseNum {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int originalNum = num;
        int rev = 0;
        while (num != 0){
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        System.out.println("The reverse of number " + originalNum + " is " + rev);
    }
}
