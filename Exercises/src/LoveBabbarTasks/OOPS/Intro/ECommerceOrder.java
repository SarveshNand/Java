package LoveBabbarTasks.OOPS.Intro;

public class ECommerceOrder {
//    Attributes
    public int orderId;
    public String customerName;
    public double totalAmount;

    public ECommerceOrder(){
        System.out.println("Using Default constructor");
    }
    public ECommerceOrder(int orderId, String customerName, double totalAmount){
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalAmount = totalAmount;
        System.out.println("Using Parameterized Constructor");
    }

    public void display(){
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Total Amount: " + totalAmount);
    }
}
