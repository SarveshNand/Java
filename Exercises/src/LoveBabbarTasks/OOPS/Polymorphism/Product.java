package LoveBabbarTasks.OOPS.Polymorphism;

public class Product {
    int productId;
    String name;
    double price;
    double weight;

    Product(int productId, String name, double price, double weight){
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    double calculateDiscount(){
        return 0;
    }

    double calculateTax(){
        return 0;
    }

    double calculateShippingCost(){
        return 0;
    }

    String getReturnPolicy(){
        return "No return policy";
    }
}
