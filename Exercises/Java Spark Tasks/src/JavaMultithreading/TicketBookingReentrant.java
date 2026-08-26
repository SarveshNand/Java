package JavaMultithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingReentrant {
    private int availableSeats = 1;
    private final Lock lock = new ReentrantLock();

    public void bookTicket(String userName){
        lock.lock();
        try {
            if (availableSeats>0){
                System.out.println(userName + " booked the ticket.");
                availableSeats--;
            } else {
                System.out.println("Sorry " + userName + ", no seats available.");
            }
        } finally {
            lock.unlock();
        }
    }
}
