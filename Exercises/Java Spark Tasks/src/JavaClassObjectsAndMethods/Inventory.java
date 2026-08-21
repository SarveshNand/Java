package JavaClassObjectsAndMethods;

public class Inventory {
    String name;
    int stock;

    void addStock(int quantity){
        stock += quantity;
    }
    void sell(int quantity){
        if (quantity<=stock){
            stock -= quantity;
            System.out.println(quantity + " items sold successfully.");
        } else {
            System.out.println("Sale failed: Not enough stock available.");
        }
    }
}
