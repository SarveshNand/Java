package LoveBabbarTasks.OOPS.Inheritance;

public class CurrentAccount extends BankingAccount {
    double overdraftLimit;

    public CurrentAccount(int accountNumber, double balance, double overdraftLimit){
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public boolean overdraft(double amount){
        if (balance + overdraftLimit >= amount){
            balance -= amount;
            return true;
        }
        return false;
    }
}
