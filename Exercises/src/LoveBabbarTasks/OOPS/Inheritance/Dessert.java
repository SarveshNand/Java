package LoveBabbarTasks.OOPS.Inheritance;

public class Dessert extends MenuItem{
    String flavor;

    Dessert(String name, double price, String flavor){
        super(name, price);
        this.flavor = flavor;
    }

    void prepare(){
        System.out.println("Preparing " + flavor + " dessert.");
    }
}
