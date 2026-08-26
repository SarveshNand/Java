package JavaMultithreading;

public class TicketBooking {
    private int availableSeats =1;

    public synchronized void bookTicket(String userName){
        if (availableSeats > 0){
            System.out.println(userName + " booked the ticket.");
            availableSeats--;
        } else {
            System.out.println("Sorry " + userName + ", no seats available.");
        }
    }
}
