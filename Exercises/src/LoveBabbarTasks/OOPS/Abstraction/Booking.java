package LoveBabbarTasks.OOPS.Abstraction;

import java.time.LocalDateTime;

abstract class Booking {
    protected String bookingId;
    protected Passenger passenger;
    protected Flight flight;
    protected Seat seat;
    protected LocalDateTime bookingDate;
    protected BookingStatus status;

    Booking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.flight = flight;
        this.seat = seat;
        this.bookingDate = LocalDateTime.now();
        this.status = BookingStatus.WAITLISTED;
    }

    abstract double calculateFare();

    void confirm() {
        status = BookingStatus.CONFIRMED;
        seat.reserve();
        System.out.println("Booking " + bookingId + " confirmed");
    }

    void cancel() {
        status = BookingStatus.CANCELLED;
        seat.release();
        System.out.println("Booking " + bookingId + " cancelled");
    }

    void generateTicket() {
        System.out.println("Ticket generated for booking " + bookingId);
    }

    void displayBooking() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Passenger: " + passenger.name);
        System.out.println("Flight: " + flight.flightNumber);
        System.out.println("Seat: " + seat.seatNumber);
        System.out.println("Status: " + status);
        System.out.println("Fare: ₹" + calculateFare());
    }
}
