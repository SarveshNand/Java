package LoveBabbarTasks.OOPS.Inheritance;

public class Furniture extends Product{
    public Furniture(String name, double price){
        super(name, price);
    }

    public void material(String material){
        System.out.println("The material used in this furniture: " + material);
    }
}
