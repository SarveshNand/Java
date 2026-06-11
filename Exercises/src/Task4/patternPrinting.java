// Think by co-ordinates rather than row and column wise !!!

package Task4;

import java.util.Scanner;
public class patternPrinting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);



        System.out.print("Enter the number: ");
        int n = input.nextInt();



//        for (int i = 1; i <= 4; i++) {
//            for (int j = 1; j <= 4; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                if (i == 1 || j == 3){
//                    System.out.print(" * ");
//                }
//                else{
//                    System.out.print("   ");
//                }
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(" * ");
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 5; j >= i; j--) {
//                System.out.print(" * ");
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 4; i++) {
//            for (int j = 1; j <= 4; j++) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(j);
//            }
//            System.out.println();
//        }



//        int counter = 1;
//        for (int i = 1; i <= 4; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(counter + " ");
//                counter++;
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 4; j >= i; j--) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= (i-1); j++) {
//                System.out.print(" ");
//            }
//            for (int k = 5; k >= i; k--) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= i; j++) {
//                if ((i + j) % 2 == 0){
//                    System.out.print(1 + " ");
//                }
//                else{
//                    System.out.print(0 + " ");
//                }
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n-i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = 1; i <= n-1; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(" ");
//            }
//            for (int j = 1; j <= n-i; j++) {
//                System.out.print("* ");
//            }
//            System.out.println();
//        }



//        int counter = 1;
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(counter + " ");
//                counter++;
//            }
//            System.out.println();
//        }



//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= i; j++) {
//                System.out.print(i - j + 1 + " ");
//            }
//            System.out.println();
//        }



        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char)('A' + (j - 1)) + " ");
            }
            System.out.println();
        }
    }
}
