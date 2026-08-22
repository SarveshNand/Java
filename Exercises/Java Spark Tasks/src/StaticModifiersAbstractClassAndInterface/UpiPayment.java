package StaticModifiersAbstractClassAndInterface;

public class UpiPayment extends BasePayment implements PaymentGateway{
    String upiId;

    UpiPayment(String transactionId, String upiId){
        super(transactionId);
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount){
        System.out.println("Payment of ₹" + amount + " made using UPI");
        System.out.println("UPI ID: " + upiId);
        printReceipt();
    }
}
