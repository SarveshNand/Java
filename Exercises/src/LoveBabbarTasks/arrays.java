package LoveBabbarTasks;

import java.util.Scanner;

public class arrays {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
//        1D Array Problems

        int[] arr = {23, 34, 123, 45, 546};

//        Problem 1: Sum of Elements
//        int sum = 0;
//        for (int i = 1; i<=arr.length-1; i++){
//            sum += arr[i];
//        }
//        System.out.print("Sum: " + sum);


//        Problem 2: Maximum Element
//        int maxElement = arr[0];
//        for (int i=1; i<=arr.length-1; i++){
//            if (maxElement < arr[i]){
//                maxElement = arr[i];
//            }
//        }
//        System.out.print("Maximum Element: " + maxElement);


//        Problem 3: Minimum Element
//        int minElement = arr[0];
//        for (int i = 1; i<=arr.length-1; i++){
//            if (minElement > arr[i]){
//                minElement = arr[i];
//            }
//        }
//        System.out.print("Minimum Element: " + minElement);


//        Problem 4: Reverse Array (Two Pointer)
//        int start = 0;
//        int end = arr.length-1;
//        while (start < end){
//            int temp = arr[start];
//            arr[start] = arr[end];
//            arr[end] = temp;
//            start++;
//            end--;
//        }
//        System.out.print("Reversed array: ");
//        for (int i =0; i<=arr.length-1; i++){
//            System.out.print(arr[i] + " ");
//        }


//        Problem 5: Linear Search
//        int target = 546;
//        boolean founder = false;
//        for (int i = 1; i<=arr.length-1; i++){
//            if (arr[i]==target){
//                founder = true;
//            }
//        }
//        System.out.print(founder);



//        2D Array Problems

        int[][] brr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

//        1. Print Diagonal Elements
//        for (int i = 0; i<brr.length; i++){
//            System.out.print(brr[i][i] + " ");
//        }


//        2. Sum of Diagonal
//        int diagonalSum = 0;
//        for (int i =0; i<brr.length; i++){
//            diagonalSum += brr[i][i];
//        }
//        System.out.print(diagonalSum);


//        3. Search Element in Matrix
//        for (int i = 0; i<brr.length; i++){
//            for (int j =0; j<brr[i].length; j++){
//                System.out.print(brr[i][j] + " ");
//            }
//            System.out.println();


//        4. Check Matrix is Symmetric
//        boolean isSymmetric = true;
//        for (int i =0; i<brr.length; i++){
//            for (int j=0; j<brr[0].length; j++){
//                if (brr[i][j] != brr[j][i]){
//                    isSymmetric = false;
//                    break;
//                }
//            }
//            if (!isSymmetric){
//                break;
//            }
//        }
//        if (isSymmetric){
//            System.out.println("Matrix is Symmetric");
//        } else {
//            System.out.println("Matrix is not Symmetric");
//        }


//        5. Spiral Matrix (Advanced)
        int top = 0;
        int bottom = brr.length-1;
        int left = 0;
        int right = brr[0].length-1;
        while (top <= bottom && left <= right){
            for (int i = left; i<=right; i++){
                System.out.print(brr[top][i] + " ");
            }
            top++;
            for (int i = top; i<=bottom; i++){
                System.out.print(brr[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(brr[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(brr[i][left] + " ");
                }
                left++;
            }
        }
    }
}
