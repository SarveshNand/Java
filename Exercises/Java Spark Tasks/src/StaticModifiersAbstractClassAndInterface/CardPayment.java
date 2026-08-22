package StaticModifiersAbstractClassAndInterface;

public class CardPayment extends BasePayment implements PaymentGateway{
    String cardNumber;

    CardPayment(String transactionId, String cardNumber) {
        super(transactionId);
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " made using Card");
        System.out.println("Card Number: " + cardNumber);
        printReceipt();
    }
}
