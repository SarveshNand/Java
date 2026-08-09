package LoveBabbarTasks.OOPS.Abstraction;

public class EconomySeat extends Seat{
    EconomySeat(String seatNumber, int rowNumber) {
        super(seatNumber, rowNumber);
    }

    @Override
    double calculateSeatPrice() {
        return 500;
    }
}
