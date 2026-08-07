package LoveBabbarTasks.OOPS.Inheritance;

public class BankingAccount {
    int accountNumber;
    protected double balance;

    public BankingAccount(){}
    public BankingAccount(int accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(int number){
        if (number > 0){
            balance += number;
        }
    }

    public void withdraw(int number){
        if (balance >= number){
            balance -= number;
        }
    }

    public double getBalance(){
        return this.balance;
    }
}
