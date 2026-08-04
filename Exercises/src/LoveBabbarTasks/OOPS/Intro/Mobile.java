package LoveBabbarTasks.OOPS.Intro;

public class Mobile {
//    Attributes
    public String brand;
    public double price;

    public Mobile(){
        brand = "Samsung";
        price = 25000;
    }

    public void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Price: " + price);
    }
}
