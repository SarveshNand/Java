package LoveBabbarTasks.OOPS.Polymorphism;

public class Food extends Product{
    String expiryDate;
    boolean isPerishable;

    Food(int productId, String name, double price, double weight, String expiryDate, boolean isPerishable){
        super(productId, name, price, weight);
        this.expiryDate = expiryDate;
        this.isPerishable = isPerishable;
    }

    @Override
    double calculateDiscount(){
        return price * 5/100;
    }

    @Override
    double calculateTax(){
        return price * 5/100;
    }

    @Override
    double calculateShippingCost(){
        return 80 + (weight * 30);
    }

    @Override
    String getReturnPolicy(){
        return "No return";
    }
}
