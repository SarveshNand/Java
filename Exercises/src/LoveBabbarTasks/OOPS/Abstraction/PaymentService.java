package LoveBabbarTasks.OOPS.Abstraction;

public class PaymentService implements TransactionCapable {

    @Override
    public void processTransaction(double amount) {
        System.out.println("Transaction processed: ₹" + amount);
    }
}
