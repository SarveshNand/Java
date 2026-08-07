package LoveBabbarTasks.OOPS.Inheritance;

class CreditCardPayment extends Payment{
    String cardNumber;

    CreditCardPayment(double amount, String cardNumber){
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void pay(){
        System.out.println("Paid ₹" + amount + " using Credit Card.");
        System.out.println("Card Number: " + cardNumber);
    }
}
