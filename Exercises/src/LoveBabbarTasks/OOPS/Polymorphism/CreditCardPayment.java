package LoveBabbarTasks.OOPS.Polymorphism;

public class CreditCardPayment extends Payment{
    private int cardNumber;
    String cardHolderName;

    public CreditCardPayment(double amount, String transactionId, int cardNumber, String cardHolderName){
        super(amount, transactionId);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    void pay(){
        System.out.println("Payment by Credit Card of " + cardHolderName);
    }

    int getCreditCardNumber(){
        return cardNumber;
    }
}
