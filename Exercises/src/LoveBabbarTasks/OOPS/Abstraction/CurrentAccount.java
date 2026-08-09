package LoveBabbarTasks.OOPS.Abstraction;

public class CurrentAccount extends Account implements OverdraftEnabled{
    double overdraftLimit;

    CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimit){
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount){
        if (amount <= balance + overdraftLimit){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Amount exceeds overdraft limit");
        }
    }

    @Override
    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    @Override
    public boolean useOverdraft(double amount){
        if (amount <= overdraftLimit){
            balance -= amount;
            return true;
        }
        return false;
    }
}
