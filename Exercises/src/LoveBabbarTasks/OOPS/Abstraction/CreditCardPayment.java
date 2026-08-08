package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

class CreditCardPayment extends Payment{

    CreditCardPayment(BigDecimal amount, String transactionId){
        super(amount, transactionId);
    }

    @Override
    public void pay(){
        System.out.println("Processing credit card payment...");
        status = PaymentStatus.SUCCESS;
    }

    @Override
    public void refund(){
        System.out.println("Refunding to credit card...");
        status = PaymentStatus.REFUNDED;
    }
}
