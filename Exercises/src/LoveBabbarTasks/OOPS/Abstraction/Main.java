package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        Payment payment1 = new CreditCardPayment(new BigDecimal(5000), "CC101");
        Payment payment2 = new UPIPayment(new BigDecimal(2000), "UPI101");
        Payment payment3 = new PayPalPayment(new BigDecimal(3000), "PP101");
        Payment payment4 = new CashOnDelivery(new BigDecimal(1500), "COD101");
        payment1.pay();
        payment1.checkStatus();
        payment1.refund();
        payment1.checkStatus();
        System.out.println();
        payment2.pay();
        payment2.checkStatus();
        System.out.println();
        payment3.pay();
        payment3.checkStatus();
        System.out.println();
        payment4.pay();
        payment4.checkStatus();
    }
}
