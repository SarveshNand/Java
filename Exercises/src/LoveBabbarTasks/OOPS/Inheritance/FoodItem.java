package LoveBabbarTasks.OOPS.Inheritance;

public class FoodItem {
    String name;
    double price;

    public FoodItem(){}
    public FoodItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public void showMenu(){
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}
