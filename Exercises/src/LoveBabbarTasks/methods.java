package LoveBabbarTasks;

public class methods {
    static void main() {
//        printWelcomeMessage();

//        int added = add(5, 6);
//        System.out.print(added);

//        boolean evenCheck = isEven(47);
//        System.out.print(evenCheck);

//        int maxNum = getMaximum(45, 23);
//        System.out.print(maxNum);

//        double calc = calculatePercentage(300, 500);
//        System.out.println(calc);

//        System.out.println(display(23));
//        System.out.print(display("Hello"));

        int num = 5;
        System.out.println("inside main: " + num);
        System.out.println("inside method: " + updateValue(num));
        System.out.print("inside main: " + num);
    }

//    1. Create a method PRINTWELCOMEMESSAGE() that prints a greeting.
    static void printWelcomeMessage(){
        System.out.print("Welcome!");
    }

//    2. Create a method ADD(int A, int B) that returns the sum.
    static int add(int a, int b){
        int sum = a+b;
        return sum;
    }

//    3. Create a method ISEVEN(int number) that returns true if number is even.
    static boolean isEven(int number){
        return number % 2 == 0;
    }

//    4. Create a method getMaximum(int a, int b) that returns the larger number.
    static int getMaximum(int a, int b){
        if (a>b){
            return a;
        }else{
            return b;
        }
    }

//    5. Create a method CalculatePercentage(int Obtained, int total).
    static double calculatePercentage(double obtained, double total){
        double calc = (obtained/total)*100;
        return calc;
    }

//    6. Create an overload method display() with one int parameter or one string parameter.
    static int display(int num){
        return num;
    }
    static String display(String message){
        return message;
    }

//    7. Write a method UpdateValue(int x) and verify that original variable in main() does not change.
    static int updateValue(int x){
        x = x * 37;
        return x;
    }
}
