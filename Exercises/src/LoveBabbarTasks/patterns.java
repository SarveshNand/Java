package LoveBabbarTasks;

import java.util.Scanner;

public class patterns {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();

//Pattern 1: Solid Square Pattern
//Problem
//Print a solid square of size n.
//* * * *
//* * * *
//* * * *
//* * * *
//        for (int i = 1; i <= n; i++){
//            for (int j = 1; j<=n; j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//Pattern 2: Hollow Square Pattern
//Problem
//Print a hollow square of size n.
//* * * * *
//*       *
//*       *
//*       *
//* * * * *
//        for (int i=1; i<=n; i++){
//            for (int j=1; j<=n; j++){
//                if (i == 1 || i == n || j == 1 || j == n){
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }


//Pattern 3: Solid Right-Angle Triangle Pattern
//Problem
//Print a right-angle triangle.
//*
//* *
//* * *
//* * * *
//* * * * *
//        for (int i = 1; i<=n; i++){
//            for (int j = 1; j<=i; j++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//Pattern 4: Inverted Right-Angle Triangle Pattern
//Problem
//Print an inverted right-angle triangle.
//* * * * *
//* * * *
//* * *
//* *
//*
//        for (int i = 1; i<=n; i++){
//            for (int j = n; j>=i; j--){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//Pattern 5: Solid Pyramid Pattern
//Problem
//Print a solid pyramid.
//      *
//    * * *
//  * * * * *
//* * * * * * *
//        for (int i =1; i<=n; i++){
//            for (int j = 1; j<=n-i; j++){
//                System.out.print("  ");
//            }
//            for (int k =1; k<=2*i-1; k++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//3. Hollow Right-Angle Triangle Pattern
//For n = 5
//*
//* *
//*   *
//*     *
//* * * * *
//        for (int i =1; i<=5; i++){
//            for (int j=1; j<=i; j++){
//                if (j==1 || i==n || j==i){
//                    System.out.print("* ");
//                }
//                else{
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }


//4. Inverted Solid Pyramid Pattern
//For n = 4
//* * * * * * *
//  * * * * *
//    * * *
//      *
//        for (int i =1; i<=4; i++){
//            for (int j = 1; j <= i-1; j++){
//                System.out.print("  ");
//            }
//            for (int k = 1; k<=2*(4-i)+1; k++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//5. Hollow Pyramid Pattern
//For n = 5
//        *
//      *   *
//    *       *
//  *           *
//* * * * * * * * *
//        for (int i =1; i<=5; i++){
//            for (int j =1; j<=5-i; j++){
//                System.out.print("  ");
//            }
//            for (int j=1; j<=2*i-1; j++){
//                if (j==1 || i==5 || j==2*i-1){
//                    System.out.print("* ");
//                } else{
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }


//6. Solid Diamond Pattern
//For n = 4
//     *
//    * * *
//  * * * * *
//* * * * * * *
//  * * * * *
//    * * *
//      *
//        int n = 4;
//        for (int i =1; i<=n; i++){
//            for (int space = 1; space <= n-i; space++){
//                System.out.print("  ");
//            }
//            for (int star = 1; star <= 2*i-1; star++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i = n-1; i>=1; i--){
//            for (int space = 1; space <= n-i; space++){
//                System.out.print("  ");
//            }
//            for (int star = 1; star <= 2*i-1; star++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//7. Hollow Diamond Pattern
//For n = 4
//      *
//    *   *
//  *       *
//*           *
//  *       *
//    *   *
//      *
//        int n = 4;
//        for (int i=1; i<=n; i++){
//            for (int space =1; space <= n-i; space++){
//                System.out.print("  ");
//            }
//            for (int star =1; star<=2*i-1; star++){
//                if (star == 2*i-1 || star==1){
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }
//        for (int i = n-1; i>=1; i--){
//            for (int space =1; space <= n-i; space++){
//                System.out.print("  ");
//            }
//            for (int star =1; star<=2*i-1; star++){
//                if (star == 2*i-1 || star==1){
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }


//8. Butterfly Pattern
//For n = 4
//*             *
//* *         * *
//* * *     * * *
//* * * * * * * *
//* * * * * * * *
//* * *     * * *
//* *         * *
//*             *
//        int n = 4;
//        for (int i =1; i<=4; i++){
//            for (int star = 1; star<=i; star++){
//                System.out.print("* ");
//            }
//            for (int space = 1; space<=2*(n-i); space++){
//                System.out.print("  ");
//            }
//            for (int star = 1; star<=i; star++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i=n; i>=1; i--){
//            for (int star = 1; star<=i; star++){
//                System.out.print("* ");
//            }
//            for (int space = 1; space<=2*(n-i); space++){
//                System.out.print("  ");
//            }
//            for (int star = 1; star<=i; star++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//9. Rhombus Pattern
//For n = 5
//        * * * * *
//      * * * * *
//    * * * * *
//  * * * * *
//* * * * *
//        int n=5;
//        for (int i=n; i>=1; i--){
//            for (int space=1; space<=i-1; space++){
//                System.out.print("  ");
//            }
//            for (int star =1; star<=n; star++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//10. Number Triangle Pattern
//For n = 5
//1
//1 2
//1 2 3
//1 2 3 4
//1 2 3 4 5
//        int n=5;
//        for (int i =1; i<=n; i++){
//            for (int j=1; j<=i; j++){
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }


//11. Symmetric Number Pyramid Pattern
//For n = 4
//      1
//    1 2 1
//  1 2 3 2 1
//1 2 3 4 3 2 1
//        int n=4;
//        for (int i = 1; i<=n; i++){
//            for (int space = 1; space<=2*(n-i); space++){
//                System.out.print(" ");
//            }
//            for (int number = 1; number <= i; number++){
//                System.out.print(number + " ");
//            }
//            for (int number = i-1; number>=1; number--){
//                System.out.print(number + " ");
//            }
//            System.out.println();
//        }


//12. Number Pyramid Pattern
//For n = 4
//      1
//    2 2 2
//  3 3 3 3 3
//4 4 4 4 4 4 4
//        int n=4;
//        for (int i = 1; i<=n; i++){
//            for (int space = 1; space<=2*(n-i); space++){
//                System.out.print(" ");
//            }
//            for (int number = 1; number<=i; number++){
//                System.out.print(i + " ");
//            }
//            for (int number = i-1; number>=1; number--){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }


//13. Floyd’s Triangle Pattern
//For n = 5
//1
//2 3
//4 5 6
//7 8 9 10
//11 12 13 14 15
//        int n=5;
//        int num=1;
//        for (int i =1; i<=n; i++){
//            for (int j=1; j<=i; j++){
//                System.out.print(num+" ");
//                num++;
//            }
//            System.out.println();
//        }


//14. Alphabet Triangle Pattern
//For n = 5
//A
//A B
//A B C
//A B C D
//A B C D E
//        int n =5;
//        for (int i=1; i<=n; i++){
//            for (char ch='A'; ch<'A'+i; ch++){
//                System.out.print(ch + " ");
//            }
//            System.out.println();
//        }


//15. Inverted Alphabet Triangle Pattern
//For n = 5
//A B C D E
//A B C D
//A B C
//A B
//A
//        int n = 5;
//        for (int i =n; i>=1; i--){
//            for (char ch = 'A'; ch<'A'+i; ch++){
//                System.out.print(ch+" ");
//            }
//            System.out.println();
//        }


//16. Symmetric Alphabet Pyramid Pattern
//For n = 4
//      A
//    A B A
//  A B C B A
//A B C D C B A
//        int n =4;
//        for (int i = 1; i<=n; i++){
//            for (int space=1; space<=n-i; space++){
//                System.out.print("  ");
//            }
//            for (char ch='A'; ch<'A'+i; ch++){
//                System.out.print(ch + " ");
//            }
//            for (char ch = (char)('A' + i - 2); ch >= 'A'; ch--){
//                System.out.print(ch + " ");
//            }
//            System.out.println();
//        }


//17. Reverse Alphabet Right-Angle Triangle Pattern
//For n = 5
//E
//E D
//E D C
//E D C B
//E D C B A
//        int n =5;
//        for (int i=1; i<=n; i++){
//            for (char ch='E'; ch>='E'-i+1; ch--){
//                System.out.print(ch + " ");
//            }
//            System.out.println();
//        }


//18. Pascal’s Triangle Pattern
//For n = 5
//1
//1 1
//1 2 1
//1 3 3 1
//1 4 6 4 1
//        int n = 5;
//        for(int i = 1; i<=n; i++){
//            int num =1;
//            for (int j=1; j<=i; j++){
//                System.out.print(num + " ");
//                num = num * (i-j)/j;
//            }
//            System.out.println();
//        }


//19. Hourglass Shape Pattern
//For n = 4
//* * * * * * *
//  * * * * *
//    * * *
//      *
//    * * *
//  * * * * *
//* * * * * * *
//        int n = 4;
//        for (int i = 1; i<=n; i++){
//            for (int space = 1; space <= 2*(i-1); space++){
//                System.out.print(" ");
//            }
//            for (int stars = 1; stars <= 2*(n-i)+1; stars++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }
//        for (int i=2; i<=n; i++){
//            for (int space =1; space <= 2*(n-i); space++){
//                System.out.print(" ");
//            }
//            for (int stars = 1; stars <= 2*i-1; stars++){
//                System.out.print("* ");
//            }
//            System.out.println();
//        }


//20. Zig-Zag Pattern
//For n = 9
//    *       *
//  *   *   *   *
//*       *       *
//        int n=9;
//        for (int i =1; i<=3; i++){
//            for (int j=1; j<=n; j++){
//                if ((i+j)%4==0 || (i == 2 && j%4==0)){
//                    System.out.print("* ");
//                } else {
//                    System.out.print("  ");
//                }
//            }
//            System.out.println();
//        }


//21. Spiral Matrix Pattern
//For n = 4
//1   2   3   4
//12  13  14  5
//11  16  15  6
//10  9   8   7
        int n = 4;
        int[][] arr = new int[n][n];
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;

        int num = 1;

        while(top<=bottom && left <= right){
            for (int i = left; i<=right; i++){
                arr[top][i] = num++;
            }
            top++;
            for (int i = top; i<=bottom; i++){
                arr[i][right] = num++;
            }
            right--;

            if (top<=bottom){
                for (int i = right; i >= left; i--) {
                    arr[bottom][i] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    arr[i][left] = num++;
                }
                left++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-4d", arr[i][j]);
            }
            System.out.println();
        }
    }
}
