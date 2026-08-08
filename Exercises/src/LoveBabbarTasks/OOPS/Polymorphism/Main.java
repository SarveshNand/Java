package LoveBabbarTasks.OOPS.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Payment payment = new CreditCardPayment(5000, "TXN101", 123456, "Rahul");
        payment.pay();
        payment.generateReceipt();
        System.out.println("-------------------------");
        payment = new UPIPayment(1500, "TXN102", "rahul@upi");
        payment.pay();
        payment.generateReceipt();
        System.out.println("-------------------------");
        payment = new CashOnDeliveryPayment(2500, "TXN103", "Delhi");
        payment.pay();
        payment.generateReceipt();
    }
}
