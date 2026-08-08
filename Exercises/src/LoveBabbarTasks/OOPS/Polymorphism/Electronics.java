package LoveBabbarTasks.OOPS.Polymorphism;

public class Electronics extends Product{
    String brand;
    int warrantyMonths;

    Electronics(int productId, String name, double price, double weight, String brand, int warrantyMonths){
        super(productId, name, price, weight);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    double calculateDiscount(){
        return price * 10/100;
    }

    @Override
    double calculateTax(){
        return price * 18/100;
    }

    @Override
    double calculateShippingCost(){
        return 100 + (weight * 20);
    }

    @Override
    String getReturnPolicy(){
        return "7 days";
    }
}
