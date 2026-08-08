package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

class UPIPayment extends Payment{

    UPIPayment(BigDecimal amount, String transactionId){
        super(amount, transactionId);
    }

    @Override
    public void pay(){
        System.out.println("Processing UPI payment...");
        status = PaymentStatus.SUCCESS;
    }

    @Override
    public void refund(){
        System.out.println("Refunding through UPI...");
        status = PaymentStatus.REFUNDED;
    }
}
