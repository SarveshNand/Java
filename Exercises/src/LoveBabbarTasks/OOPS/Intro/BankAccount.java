package LoveBabbarTasks.OOPS.Intro;

public class BankAccount {
//    Attributes
    public String accountHolder;
    public int accountNumber;
    public double balance;

    public BankAccount(String accountHolder, int accountNumber, double balance){
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void display(){
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.print("Balance: $" + this.balance);
    }
}
