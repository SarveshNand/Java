package LoveBabbarTasks.OOPS.Abstraction;

public class BusinessSeat extends Seat{
    BusinessSeat(String seatNumber, int rowNumber) {
        super(seatNumber, rowNumber);
    }

    @Override
    double calculateSeatPrice() {
        return 2000;
    }
}
