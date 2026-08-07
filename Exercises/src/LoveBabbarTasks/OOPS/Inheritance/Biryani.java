package LoveBabbarTasks.OOPS.Inheritance;

public class Biryani extends MenuItem{
    String riceType;

    Biryani(String name, double price, String riceType){
        super(name, price);
        this.riceType = riceType;
    }

    void prepare(){
        System.out.println("Preparing Biryani with " + riceType + " rice.");
    }
}
