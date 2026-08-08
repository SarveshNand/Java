package LoveBabbarTasks.OOPS.Polymorphism;

public class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(long accountNumber, String accountHolderName, double balance, double interestRate){
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    double calculateInterest(){
        return balance * interestRate / 100;
    }
}
