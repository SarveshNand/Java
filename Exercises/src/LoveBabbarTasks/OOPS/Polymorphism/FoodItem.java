package LoveBabbarTasks.OOPS.Polymorphism;

public class FoodItem {
    String name;
    double basePrice;
    int quantity;

    FoodItem(String name, double basePrice, int quantity){
        this.name = name;
        this.basePrice = basePrice;
        this.quantity = quantity;
    }

    double calculatePrice(){
        return basePrice * quantity;
    }

    void prepare(){
        System.out.println("Preparing the food");
    }

    void displayDetails(){
        System.out.println("Name of the Food: " + name);
        System.out.println("Food Quantity: " + quantity);
        System.out.println("Price of the Food: " + calculatePrice());
    }
}
