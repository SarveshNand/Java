package LoveBabbarTasks.OOPS.Abstraction;

abstract class Order {
    int orderId;
    double amount;
    String status;

    Order(int orderId, double amount){
        this.orderId = orderId;
        this.amount = amount;
        this.status = "PLACED";
    }

    void placeOrder(){
        status = "PLACED";
        System.out.println("Order placed");
    }

    void cancelOrder(){
        status = "CANCELLED";
        System.out.println("Order cancelled");
    }

    void trackOrder(){
        System.out.println("Order status: " + status);
    }

    abstract void calculateDeliveryTime();
}
