package LoveBabbarTasks.OOPS.Polymorphism;

public class Biryani extends FoodItem{
    String biryaniType;
    String servingSize;

    Biryani(String name, double basePrice, int quantity, String biryaniType, String servingSize){
        super(name, basePrice, quantity);
        this.biryaniType = biryaniType;
        this.servingSize = servingSize;
    }

    @Override
    double calculatePrice() {

        double price = basePrice;

        if (servingSize.equalsIgnoreCase("Large")) {
            price += 80;
        } else if (servingSize.equalsIgnoreCase("Medium")) {
            price += 40;
        }

        return price * quantity;
    }

    @Override
    void prepare() {
        System.out.println("Preparing " + servingSize + " " + biryaniType + " biryani");
    }
}
