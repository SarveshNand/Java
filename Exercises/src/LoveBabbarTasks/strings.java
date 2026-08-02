package LoveBabbarTasks;

import java.util.Scanner;

public class strings {
    public static void main(String[] args){
        Scanner input =  new Scanner(System.in);
//        Problem 1: Print Each Character
//        String str = "Code";
//        for (int i = 0; i<str.length(); i++){
//            System.out.println("At index " + i + " the character is: " + str.charAt(i));
//        }


//        Problem 2: Count Length Without length()
//        String str = "Java";
//        int count = 0;
//        for (char ch: str.toCharArray()){
//            count++;
//        }
//        System.out.print(count);


//        Problem 3: Count Vowels
//        System.out.print("Enter your line: ");
//        String str = input.nextLine();
//        int count = 0;
//        for (int i = 0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
//                count++;
//            }
//        }
//        System.out.print("The total vowels in the given string: " + count);


//        Problem 4: Reverse a String
//        String reversed = "";
//        System.out.print("Enter something: ");
//        String str = input.nextLine();
//        for (int i = str.length()-1; i>=0; i--){
//            reversed = reversed + str.charAt(i);
//        }
//        System.out.print("Reversed string of your given string: " + reversed);


//        Problem 5: Check Palindrome
//        String reversed = "";
//        System.out.print("Enter your string: ");
//        String str = input.nextLine();
//        for (int i = str.length()-1; i>=0; i--){
//            reversed += str.charAt(i);
//        }
//        if (str.equals(reversed)){
//            System.out.print("String is Palindrome.");
//        } else {
//            System.out.print("String is not Palindrome.");
//        }


//        Count consonants in a string
//        System.out.print("Enter your string: ");
//        String str = input.nextLine();
//        int count = 0;
//        for (int i = 0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            if (Character.isLetter(ch) && (ch != 'a' && ch != 'e' &&  ch != 'i' && ch != 'o' && ch != 'u' && ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U')){
//                count++;
//            }
//        }
//        System.out.print("The total consonants in the given string: " + count);


//        Convert string to uppercase without using method
//        System.out.print("Enter a string: ");
//        String str = input.nextLine();
//        String result = "";
//        for (int i = 0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            if (ch >= 'a' && ch <= 'z'){
//                ch = (char)(ch-32);
//            }
//            result += ch;
//        }
//        System.out.print("Uppercase without method: " + result);


//        Find frequency of a character
//        System.out.print("Enter a string: ");
//        String str = input.nextLine();
//        System.out.print("Enter the character to find: ");
//        char target = Character.toLowerCase(input.next().charAt(0));
//        int count = 0;
//        for (int i = 0; i<str.length(); i++){
//            if (str.charAt(i) == target){
//                count++;
//            }
//        }
//        System.out.print("Frequency of '" + target + "' = " + count);


//        Remove all spaces from string
//        System.out.print("Enter a string: ");
//        String str = input.nextLine();
//        String result = "";
//        for (int i =0; i<str.length(); i++){
//            char ch = str.charAt(i);
//            if (ch != ' '){
//                result += ch;
//            }
//        }
//        System.out.print("String without spaces: " + result);


//        Check if string contains only digits
//        System.out.print("Enter a string: ");
//        String str = input.nextLine();
//        boolean onlyDigits = true;
//        for (int i =0; i<str.length(); i++){
//            char ch =  str.charAt(i);
//            if (ch <= '0' || ch > '9'){
//                onlyDigits = false;
//                break;
//            }
//        }
//        if (onlyDigits){
//            System.out.println("The string contains only digits.");
//        } else {
//            System.out.println("The string does not contains only digits.");
//        }


//        Count words in a sentence
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        int count = 0;
        for (int i = 0; i<str.length(); i++){
            if ((i==0 && str.charAt(i) != ' ') || (i>0 && str.charAt(i) != ' ' && str.charAt(i-1) == ' ')){
                count++;
            }
        }
        System.out.print("Number of words: " + count);
    }
}
