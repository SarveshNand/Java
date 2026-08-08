package LoveBabbarTasks.OOPS.Polymorphism;

public class Book extends Product{
    String author;
    int numberOfPages;

    Book(int productId, String name, double price, double weight, String author, int numberOfPages){
        super(productId, name, price, weight);
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    @Override
    double calculateDiscount(){
        return price * 10/100;
    }

    @Override
    double calculateTax(){
        return price * 5/100;
    }

    @Override
    double calculateShippingCost(){
        return 40 + (weight * 10);
    }

    @Override
    String getReturnPolicy(){
        return "30 days";
    }
}
