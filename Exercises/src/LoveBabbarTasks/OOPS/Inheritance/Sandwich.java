package LoveBabbarTasks.OOPS.Inheritance;

public class Sandwich extends MenuItem{
    String filling;

    Sandwich(String name, double price, String filling){
        super(name, price);
        this.filling = filling;
    }

    void prepare(){
        System.out.println("Preparing Sandwich with " + filling + " filling.");
    }
}
