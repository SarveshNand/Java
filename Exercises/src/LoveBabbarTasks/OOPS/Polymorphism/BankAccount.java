package LoveBabbarTasks.OOPS.Polymorphism;

public class BankAccount {
    private long accountNumber;
    String accountHolderName;
    protected double balance;

    BankAccount(long accountNumber, String accountHolderName, double balance){
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    double deposit(double amount){
        if (amount > 0){
            balance += amount;
        }
        return balance;
    }

    double withdraw(double amount){
        if (amount > 0 && balance >= amount){
            balance -= amount;
        }
        return balance;
    }

    double calculateInterest(){
        return 0;
    }

    double displayBalance(){
        return this.balance;
    }
}
