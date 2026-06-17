import java.util.Scanner;

public class countDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int count = 0;
        int temp = Math.abs(n);
        if (temp == 0){
            count = 1;
        } else {
            while (temp > 0){
                temp /= 10;
                count++;
            }
        }
        System.out.println("The number " + n + " has " + count + " digits.");
    }
}
