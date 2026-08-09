package LoveBabbarTasks.OOPS.Abstraction;

class BusinessBooking extends Booking implements Refundable {

    BusinessBooking(String bookingId, Passenger passenger, Flight flight, Seat seat) {
        super(bookingId, passenger, flight, seat);
    }

    @Override
    double calculateFare() {
        return flight.calculatePrice() + seat.calculateSeatPrice() + 5000;
    }

    @Override
    public double calculateRefund() {
        return calculateFare() * 0.80;
    }
}
