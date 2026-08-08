package LoveBabbarTasks.OOPS.Polymorphism;

public class Payment {
    double amount;
    String transactionId;

    public Payment(double amount, String transactionId){
        this.amount = amount;
        this.transactionId = transactionId;
    }

    void pay(){
        System.out.println("Payment by any means");
    }

    void generateReceipt(){
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Payment successful.");
    }
}
