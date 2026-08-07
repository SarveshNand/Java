package LoveBabbarTasks.OOPS.Inheritance;

public class NetBankingPayment extends Payment{
    String bankName;

    NetBankingPayment(double amount, String bankName) {
        super(amount);
        this.bankName = bankName;
    }

    @Override
    void pay() {
        System.out.println("Paid ₹" + amount + " using Net Banking.");
        System.out.println("Bank Name: " + bankName);
    }
}
