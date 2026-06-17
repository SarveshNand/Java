import java.util.Scanner;
public class divisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int num = sc.nextInt();

        System.out.print("Divisors: [");

        boolean first = true;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0){
                if (!first){
                    System.out.print(", ");
                }
                System.out.print(i);
                first = false;
            }
        }
        System.out.print("]");
    }
}
