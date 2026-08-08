package LoveBabbarTasks.OOPS.Polymorphism;

public class Pizza extends FoodItem{
    String size;
    String toppings;

    Pizza(String name, double basePrice, int quantity, String size, String toppings){
        super(name, basePrice, quantity);
        this.size = size;
        this.toppings = toppings;
    }

    @Override
    double calculatePrice(){
        double price = basePrice;

        if (size.equalsIgnoreCase("Large")){
            price += 100;
        } else if (size.equalsIgnoreCase("Medium")) {
            price += 50;
        }

        if (!toppings.equalsIgnoreCase("None")){
            price += 50;
        }

        return price * quantity;
    }

    @Override
    void prepare(){
        System.out.println("Preparing " + size + " pizza with " + toppings);
    }
}
