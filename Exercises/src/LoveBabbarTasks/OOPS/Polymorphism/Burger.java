package LoveBabbarTasks.OOPS.Polymorphism;

public class Burger extends FoodItem{
    String pattyType;
    boolean extraCheese;

    Burger(String name, double basePrice, int quantity, String pattyType, boolean extraCheese){
        super(name, basePrice, quantity);
        this.pattyType = pattyType;
        this.extraCheese = extraCheese;
    }

    @Override
    double calculatePrice(){
        double price = basePrice;
        if (pattyType.equalsIgnoreCase("Chicken")) {
            price += 50;
        }

        if (extraCheese) {
            price += 30;
        }

        return price * quantity;
    }

    @Override
    void prepare(){
        System.out.println("Preparing " + pattyType + " burger");
    }
}
