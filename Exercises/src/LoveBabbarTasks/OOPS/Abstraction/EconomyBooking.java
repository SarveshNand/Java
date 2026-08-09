package LoveBabbarTasks.OOPS.Abstraction;

class EconomyBooking extends Booking implements Refundable {

    EconomyBooking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
        super(bookingId, passenger, flight, seat);
    }

    @Override
    double calculateFare() {
        return flight.calculatePrice() + seat.calculateSeatPrice();
    }

    @Override
    public double calculateRefund() {
        return calculateFare() * 0.50;
    }
}