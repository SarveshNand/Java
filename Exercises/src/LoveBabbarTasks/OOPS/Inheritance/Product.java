package LoveBabbarTasks.OOPS.Inheritance;

public class Product{
    String name;
    double price;

    public Product(){}

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void displayDetails(){
        System.out.println("Name of the product: " + name);
        System.out.println("Price of the product: " + price);
    }
}
