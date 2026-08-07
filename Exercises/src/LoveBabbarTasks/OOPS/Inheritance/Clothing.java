package LoveBabbarTasks.OOPS.Inheritance;

public class Clothing extends Product{
    public Clothing(String name, double price){
        super(name, price);
    }

    public void size(int size){
        System.out.println("The size of the cloth is: " + size);
    }
}
