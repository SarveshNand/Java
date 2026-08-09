package LoveBabbarTasks.OOPS.Abstraction;

class Electronics extends Product implements Discountable, Shippable{

    Electronics(int productId, String name, double price, int quantity){
        super(productId, name, price, quantity);
    }

    @Override
    public double calculateDiscount(){
        return price * 0.10;
    }

    @Override
    public double calculateShippingCost(){
        return 100;
    }
}
