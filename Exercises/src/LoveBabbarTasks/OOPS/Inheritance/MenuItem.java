package LoveBabbarTasks.OOPS.Inheritance;

public class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    void display(){
        System.out.println("Item name: " + name);
        System.out.println("Price: ₹" + price);
    }
}
