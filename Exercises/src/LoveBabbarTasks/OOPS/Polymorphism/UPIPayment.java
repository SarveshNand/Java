package LoveBabbarTasks.OOPS.Polymorphism;

public class UPIPayment extends Payment{
    String upiId;

    public UPIPayment(double amount, String transactionId, String upiId){
        super(amount, transactionId);
        this.upiId = upiId;
    }

    @Override
    void pay(){
        System.out.println("Payment by UPI Id of " + upiId);
    }
}
