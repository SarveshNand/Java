package LoveBabbarTasks.OOPS.Intro;

public class Laptop {
    public String brand;
    public String ram;
    public double price;

    public Laptop(){
        brand = "Dell";
        ram = "8GB";
        price = 55000;
    }

    public void display(){
        System.out.println("Brand = " + brand);
        System.out.println("RAM = " + ram);
        System.out.println("Price = " + price);
    }
}
