package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

class PayPalPayment extends Payment{

    PayPalPayment(BigDecimal amount, String transactionId){
        super(amount, transactionId);
    }

    @Override
    public void pay(){
        System.out.println("Processing PayPal payment...");
        status = PaymentStatus.SUCCESS;
    }

    @Override
    public void refund(){
        System.out.println("Refunding through PayPal...");
        status = PaymentStatus.REFUNDED;
    }
}
