package LoveBabbarTasks.OOPS.Abstraction;

class FirstClassBooking extends Booking implements Refundable {

    FirstClassBooking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
        super(bookingId, passenger, flight, seat);
    }

    @Override
    double calculateFare() {
        return flight.calculatePrice() + seat.calculateSeatPrice() + 10000;
    }

    @Override
    public double calculateRefund() {
        return calculateFare() * 0.95;
    }
}
