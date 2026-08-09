package LoveBabbarTasks.OOPS.Abstraction;

public class SavingsAccount extends Account implements InterestBearing{
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate){
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    void withdraw(double amount){
        if (amount <= balance){
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public double calculateInterest(){
        return balance * interestRate / 100;
    }
}
