package ExceptionHandling;

public class BankAccount {
    int accountNumber;
    String ownerName;
    private double balance;

    public BankAccount(int accountNumber, String ownerName, double balance){
        this.accountNumber = accountNumber;
        this.ownerName =ownerName;
        this.balance = balance;
    }

    void deposit(double amount) throws InvalidAmountException{
        if (amount <= 0){
            throw new InvalidAmountException("Deposit amount must be greater than 0");
        }
        balance += amount;
    }

    void withdraw(double money) throws InsufficientBalanceException, InvalidAmountException{
        if (money <= 0){
            throw new InvalidAmountException("Withdrawal amount must be greater than 0");
        }
        if (money > balance){
            throw new InsufficientBalanceException("Insufficient balance. Available balance: " + balance);
        }
        balance -= money;
    }

    double getBalance(){
        return this.balance;
    }
}

