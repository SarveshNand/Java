package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

class CashOnDelivery extends Payment{

    CashOnDelivery(BigDecimal amount, String transactionId){
        super(amount, transactionId);
    }

    @Override
    public void pay(){
        System.out.println("Processing COD Payment...");
        status = PaymentStatus.SUCCESS;
    }

    @Override
    public void refund(){
        System.out.println("Refunding through COD...");
        status = PaymentStatus.REFUNDED;
    }
}
