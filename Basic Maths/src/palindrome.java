import java.util.Scanner;
public class palindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        int originalNum = num;
        int rev = 0;
        while(num != 0){
            int digits = num % 10;
            rev =  rev * 10 + digits;
            num /= 10;
        }

        if(rev == originalNum){
            System.out.print("The reverse of " + originalNum + " is " + rev + " and therefore it is palindrome number");
        } else {
            System.out.print("The reverse of number " + originalNum + " is " + rev + " and therefore it is not palindrome number");
        }
    }
}
