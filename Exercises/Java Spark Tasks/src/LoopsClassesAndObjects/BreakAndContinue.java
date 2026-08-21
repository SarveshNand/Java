package LoopsClassesAndObjects;

public class BreakAndContinue {
    public static void main(String[] args){
        for (int i = 1; i<=20; i++){
            if (i==7){
                continue;
            }
            if (i==15){
                break;
            }
            System.out.println(i);
        }
    }
}
