package LoveBabbarTasks.OOPS.Polymorphism;

public class Clothing extends Product{
    String size;
    String material;

    Clothing(int productId, String name, double price, double weight, String size, String material){
        super(productId, name, price, weight);
        this.size = size;
        this.material = material;
    }

    @Override
    double calculateDiscount(){
        return price * 15/100;
    }

    @Override
    double calculateTax(){
        return price * 5/100;
    }

    @Override
    double calculateShippingCost(){
        return 50 + (weight * 10);
    }

    @Override
    String getReturnPolicy(){
        return "15 days";
    }
}
