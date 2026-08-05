package LoveBabbarTasks.OOPS.Encapsulation;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount){
        if (this.balance > 0){
            this.balance += amount;
        }
    }
    public void withdraw(double amount){
        if (this.balance < amount){
            System.out.println("Insufficient Balance");
        } else {
            this.balance -= amount;
        }
    }
    public double getBalance(){
        return this.balance;
    }
    public String getAccountHolder(){
        return this.accountHolder;
    }
}
