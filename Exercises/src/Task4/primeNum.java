package Task4;
import  java.util.Scanner;
public class primeNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = input.nextInt();

        boolean isPrime = true;
        if (n<=1){
            isPrime = false;
        }
        for(int i = 2; i*i <= n; i++){
            if (n % i == 0){
                isPrime = false;
                break;
            }
        }
        System.out.println(isPrime);
    }
}
