package LoveBabbarTasks.OOPS.Inheritance;

public class SavingsAccount extends BankingAccount {
    int numberOfDays;
    public SavingsAccount(int accountNumber, double balance, int numberOfDays){
        super(accountNumber, balance);
        this.numberOfDays = numberOfDays;
    }

    public double calculateInterest(double interest){
        return balance * (interest/100)*(numberOfDays/365.0);
    }
}
