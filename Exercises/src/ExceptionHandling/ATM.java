package ExceptionHandling;

public class ATM {
    private double balance;

    public ATM(double balance){
        this.balance =  balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException{
        if (amount > balance){
            throw new InsufficientBalanceException("Insufficient Balance. Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal amount: " + amount);
        System.out.println("Remaining balance: " + balance);
    }
}
