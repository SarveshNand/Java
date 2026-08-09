package LoveBabbarTasks.OOPS.Abstraction;

class Grocery extends Product implements Discountable, Shippable{

    Grocery(int productId, String name, double price, int quantity){
        super(productId, name, price, quantity);
    }

    @Override
    public double calculateDiscount(){
        return price * 0.05;
    }

    @Override
    public double calculateShippingCost(){
        return  30;
    }
}
