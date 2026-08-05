package LoveBabbarTasks.OOPS.Encapsulation;

public class MovieTicketBooking {
    private String movieName;
    private int availableSeats;
    private double ticketPrice;

    public MovieTicketBooking(String movieName, int availableSeats, double ticketPrice) {
        this.movieName = movieName;
        this.availableSeats = Math.max(availableSeats, 0);
        this.ticketPrice = Math.max(ticketPrice, 0);
    }

    public void bookTickets(int seats) {
        if (seats <= 0) {
            System.out.println("Invalid number of seats.");
            return;
        }

        if (seats > availableSeats) {
            System.out.println("Not enough seats available.");
            return;
        }

        availableSeats -= seats;
        System.out.println(seats + " ticket(s) booked.");
    }

    public void cancelTickets(int seats) {
        if (seats <= 0) {
            System.out.println("Invalid number of seats.");
            return;
        }

        availableSeats += seats;
        System.out.println(seats + " ticket(s) cancelled.");
    }

    public void changeTicketPrice(double newPrice) {
        if (newPrice < 0) {
            System.out.println("Ticket price can't be negative.");
            return;
        }

        ticketPrice = newPrice;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}
