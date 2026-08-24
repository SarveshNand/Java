package JavaExceptionHandling;

class BankAccount {
    double balance;

    BankAccount(double balance){
        this.balance = balance;
    }

    void withdraw(double amount) throws InsufficientBalanceException{
        if (amount > balance){
            throw new InsufficientBalanceException("Insufficient balance. Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful.");
        System.out.println("Remaining balance: " + balance);
    }
}
