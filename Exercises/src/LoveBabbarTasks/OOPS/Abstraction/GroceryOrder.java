package LoveBabbarTasks.OOPS.Abstraction;

class GroceryOrder extends Order{
    String storeName;

    GroceryOrder(int orderId, double amount, String storeName){
        super(orderId, amount);
        this.storeName = storeName;
    }

    @Override
    void calculateDeliveryTime(){
        System.out.println("Grocery delivery: 60 minutes");
    }

    void substituteItem(){
        System.out.println("Grocery item substituted");
    }

    void handleOutOfStock(){
        System.out.println("Item is out of stock");
    }
}
