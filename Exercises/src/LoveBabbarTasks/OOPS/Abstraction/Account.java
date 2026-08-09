package LoveBabbarTasks.OOPS.Abstraction;

abstract class Account {
    String accountNumber;
    String accountHolder;
    double balance;

    Account(String accountNumber, String accountHolder, double balance){
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void deposit(double amount){
        if (amount > 0){
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    abstract void withdraw(double amount);

    void displayBalance(){
        System.out.println("Balance: " + balance);
    }
}
