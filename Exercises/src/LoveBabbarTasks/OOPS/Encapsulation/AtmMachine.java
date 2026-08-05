package LoveBabbarTasks.OOPS.Encapsulation;

public class AtmMachine {
    private int pin;
    private double balance;
    private boolean isLoggedIn;

    public AtmMachine(int pin, double balance){
        this.pin = pin;
        this.balance = balance;
        this.isLoggedIn = false;
    }

    public void login(int enteredPin){
        if (enteredPin == this.pin){
            this.isLoggedIn = true;
            System.out.println("Login Successful");
        } else {
            System.out.println("Wrong PIN");
        }
    }

    public void deposit(double amount){
        if (!isLoggedIn){
            System.out.println("Please Login first.");
            return;
        }
        if (amount > 0){
            this.balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount){
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void changePin(int newPin){
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }

        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    public void showBalance(){
        if (!isLoggedIn) {
            System.out.println("Please login first.");
            return;
        }

        System.out.println("Balance: " + balance);
    }
}
