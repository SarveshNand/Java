package LoveBabbarTasks.OOPS.Abstraction;

class FirstClassSeat extends Seat {

    FirstClassSeat(String seatNumber, int rowNumber) {
        super(seatNumber, rowNumber);
    }

    @Override
    double calculateSeatPrice() {
        return 5000;
    }
}
