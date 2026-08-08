package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

enum PaymentStatus {
    PENDING,
    SUCCESS,
    FAILED,
    REFUNDED
}

abstract class Payment {
    protected BigDecimal amount;
    protected String transactionId;
    protected PaymentStatus status;

    public Payment(BigDecimal amount, String transactionId){
        this.amount = amount;
        this.transactionId = transactionId;
        this.status = PaymentStatus.PENDING;
    }

    public abstract void pay();

    public void checkStatus(){
        System.out.println("Payment status: " + status);
    }

    public BigDecimal getAmount(){
        return this.amount;
    }

    public String getTransactionId(){
        return this.transactionId;
    }

    public abstract void refund();
}
