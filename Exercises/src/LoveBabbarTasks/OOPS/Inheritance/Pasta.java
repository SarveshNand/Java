package LoveBabbarTasks.OOPS.Inheritance;

public class Pasta extends MenuItem{
    String sauceType;

    Pasta(String name, double price, String sauceType){
        super(name, price);
        this.sauceType = sauceType;
    }

    void prepare(){
        System.out.println("Preparing Pasta with " + sauceType + " sauce.");
    }
}
