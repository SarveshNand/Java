package LoveBabbarTasks.OOPS.Polymorphism;

public class CurrentAccount extends BankAccount{
    double overdraftLimit;

    CurrentAccount(long accountNumber, String accountHolderName, double balance, double overdraftLimit){
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    double withdraw(double amount){
        if (amount > 0 && balance + overdraftLimit >= amount){
            balance -= amount;
        }
        return balance;
    }

    @Override
    double calculateInterest(){
        return 0;
    }
}
