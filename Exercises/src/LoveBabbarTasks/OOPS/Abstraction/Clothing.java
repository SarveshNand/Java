package LoveBabbarTasks.OOPS.Abstraction;

class Clothing extends Product implements Discountable, Shippable{

    Clothing(int productId, String name, double price, int quantity){
        super(productId, name, price, quantity);
    }

    @Override
    public double calculateDiscount(){
        return price * 0.20;
    }

    @Override
    public double calculateShippingCost(){
        return  50;
    }
}
