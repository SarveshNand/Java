package LoopsClassesAndObjects;

public class EvenAndOddNumber {
    public static void main(String[] args){
        for (int i =1; i<=50; i++){
            if (i % 2 == 0){
                System.out.println("Even Numbers: " + i);
            }
        }
        for (int i =1; i<=50; i++){
            if (i % 2 != 0){
                System.out.println("Odd Numbers: " + i);
            }
        }
    }
}
