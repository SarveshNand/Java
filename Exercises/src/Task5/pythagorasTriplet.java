package Task5;
import java.util.Scanner;
public class pythagorasTriplet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        System.out.println(checkTriplets(a,b,c));
    }

    static String checkTriplets(double a, double b, double c){
        double twoNumbers = (a * a) + (b * b);
        double thirdNumber = c * c;
        if (twoNumbers == thirdNumber){
            return "It is a Pythagoras Triplet!";
        }
        return "It is not a Pythagoras Triplet!";
    }
}
