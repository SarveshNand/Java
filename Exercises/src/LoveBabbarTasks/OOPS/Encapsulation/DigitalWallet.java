package LoveBabbarTasks.OOPS.Encapsulation;

public class DigitalWallet {
    private int walletId;
    private double balance;
    private boolean isBlocked;

    public DigitalWallet(int walletId, double balance){
        this.walletId = walletId;
        this.balance = Math.max(balance, 0);
        this.isBlocked = false;
    }

    public void addMoney(double amount){
        if (isBlocked){
            System.out.println("Wallet is blocked.");
            return;
        }
        if (amount <= 0){
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        System.out.println("Money added successfully.");
    }

    public void sendMoney(double amount){
        if (isBlocked){
            System.out.println("Wallet is blocked.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.println("Money sent successfully.");
    }

    public void blockWallet(){
        isBlocked = true;
        System.out.println("Wallet blocked.");
    }

    public void unblockWallet(){
        isBlocked = false;
        System.out.println("Wallet unblocked.");
    }

    public double getBalance(){
        return this.balance;
    }
}
