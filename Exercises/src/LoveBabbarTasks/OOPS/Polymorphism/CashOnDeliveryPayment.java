package LoveBabbarTasks.OOPS.Polymorphism;

public class CashOnDeliveryPayment extends Payment{
    String deliveryAddress;

    public CashOnDeliveryPayment(double amount, String transactionId, String deliveryAddress){
        super(amount, transactionId);
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    void pay(){
        System.out.println("Payment by Cash on the address: " + deliveryAddress);
    }
}
