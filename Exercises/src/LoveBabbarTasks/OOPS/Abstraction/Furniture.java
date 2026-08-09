package LoveBabbarTasks.OOPS.Abstraction;

class Furniture extends Product implements Shippable{

    Furniture(int productId, String name, double price, int quantity){
        super(productId, name, price, quantity);
    }

    @Override
    public double calculateShippingCost(){
        return  500;
    }
}
