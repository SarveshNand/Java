package JavaClassObjectsAndMethods;

public class BankAccount {
    String accountHolder;
    double balance;

    void deposit(double amount){
        if (amount>0){
            balance += amount;
        }
    }
    void withdraw(double amount){
        if (amount<=balance){
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void displayBalance(){
        System.out.println("Balance: " + balance);
    }
}
