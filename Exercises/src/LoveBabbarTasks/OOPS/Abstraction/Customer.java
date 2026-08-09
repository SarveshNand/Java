package LoveBabbarTasks.OOPS.Abstraction;

class Customer extends User{
    String address;

    Customer(String name, long phone, String address){
        super(name, phone);
        this.address = address;
    }

    void placeOrder(){
        System.out.println(name + " placed an order");
    }

    void cancelOrder(){
        System.out.println(name + " cancelled the order");
    }

    void trackOrder(){
        System.out.println("Order is being delivered to " + address);
    }
}
