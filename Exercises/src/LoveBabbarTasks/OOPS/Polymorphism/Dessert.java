package LoveBabbarTasks.OOPS.Polymorphism;

public class Dessert extends FoodItem{
    String flavour;
    boolean isEggless;

    Dessert(String name, double basePrice, int quantity, String flavour, boolean isEggless){
        super(name, basePrice, quantity);
        this.flavour = flavour;
        this.isEggless = isEggless;
    }

    @Override
    double calculatePrice() {
        double price = basePrice;
        if (isEggless) {
            price += 20;
        }

        return price * quantity;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + flavour + " dessert");
    }
}
