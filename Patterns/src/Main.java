import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int value = scanner.nextInt();

        Patterns pattern = new Patterns();
        pattern.pattern1(value);    // Pattern 1
        pattern.pattern2(value);    // Pattern 2
        pattern.pattern3(value);    // Pattern 3
        pattern.pattern4(value);    // Pattern 4
        pattern.pattern5(value);    // Pattern 5
        pattern.pattern6(value);    // Pattern 6
        pattern.pattern7(value);    // Pattern 7
        pattern.pattern8(value);    // Pattern 8
        pattern.pattern9(value);    // Pattern 9
        pattern.pattern10(value);   // Pattern 10
        pattern.pattern11(value);   // Pattern 11
        pattern.pattern12(value);   // Pattern 12
        pattern.pattern13(value);   // Pattern 13 (Floyd's Triangle)
        pattern.pattern14(value);   // Pattern 14
        pattern.pattern15(value);   // Pattern 15
        pattern.pattern16(value);   // Pattern 16
        pattern.pattern17(value);   // Pattern 17
        pattern.pattern18(value);   // Pattern 18
        pattern.pattern19(value);   // Pattern 19
        pattern.pattern20(value);   // Pattern 20
        pattern.pattern21(value);   // Pattern 21
        pattern.pattern22(value);   // Pattern 22

        scanner.close();
    }
}

class Patterns{
    void pattern1(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern2(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern3(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    void pattern4(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }

    void pattern5(int n){
        for (int i = 1; i <= n; i++){
            for (int j = n; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern6(int n){
        for (int i = 1; i <= n; i++){
            for (int j = n; j >= i; j--){
                System.out.print(n-j+1);
            }
            System.out.println();
        }
    }

    void pattern7(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern8(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (n - i) - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern9(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= 2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern10(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= 2*i-1; j++){
                System.out.print("  ");
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = n-1; j >= i; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern11(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                if ((i+j) % 2 == 0){
                    System.out.print(1);
                } else  {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }

    void pattern12(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j);
            }
            for (int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    void pattern13(int n){
        int num = 1;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    void pattern14(int n){
        for (int i = 1; i <= n; i++){
            for (char ch = 'A'; ch < 'A' + i; ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    void pattern15(int n){
        for (int i = n; i >= 1; i--){
            for(char ch = 'A'; ch < 'A' + i; ch++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    void pattern16(int n){
        for (int i = 1; i <= n; i++){
            char ch = (char)('A' + i - 1);
            for (int j = 1; j <= i; j++){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    void pattern17(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n-i; j++){
                System.out.print(" ");
            }
            for (char ch = 'A'; ch < 'A' + i; ch++){
                System.out.print(ch);
            }
            for(char ch = (char) ('A' + i - 2); ch >= 'A'; ch--){
                System.out.print(ch);
            }
            System.out.println();
        }
    }

    void pattern18(int n){
        for(int i = 1; i <= n; i++){
            char start = (char)('A' + n - i);
            for(char ch = start; ch <= 'A' + n - 1; ch++){
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    void pattern19(int n){
        for (int i = n; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void pattern20(int n){
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n-1; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for (int j = 1; j <= 2*(n-i); j++){
                System.out.print(" ");
            }
            for (int j = i; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    int pattern21(int n){
        int rows = n;
        int cols = n;
        for (int i  = 1; i <= rows; i++){
            for (int j = 1; j <= cols; j++){
                if(i == 1 || i == rows || j == 1 || j == cols){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        return 1;
    }

    void pattern22(int n){
        int size = 2 * n - 1;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {

                int min = Math.min(
                        Math.min(i - 1, j - 1),
                        Math.min(size - i, size - j)
                );
                System.out.print(n - min);
            }
            System.out.println();
        }
    }
}