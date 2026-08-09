package LoveBabbarTasks.OOPS.Abstraction;

public class Client extends Person{
    String address;

    Client(String name, long phone, String address) {
        super(name, phone);
        this.address = address;
    }

    void placeOrder() {
        System.out.println(name + " placed an order");
    }

    void cancelOrder() {
        System.out.println(name + " cancelled the order");
    }

    void trackDelivery() {
        System.out.println("Tracking delivery to: " + address);
    }
}
