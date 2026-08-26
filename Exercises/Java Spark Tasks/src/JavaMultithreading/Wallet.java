package JavaMultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Wallet {
    private double balance = 5000;
    private final Lock lock = new ReentrantLock();

    void debit(String userName, double amount){
        if (lock.tryLock()){
            try {
                if (balance >= amount){
                    balance -= amount;
                    System.out.println(userName + " debited ₹ " + amount);
                    System.out.println("Remaining balance: ₹" + balance);
                } else {
                    System.out.println(userName + ": Insufficient balance");
                }
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(userName + ": Please try again");
        }
    }
}
