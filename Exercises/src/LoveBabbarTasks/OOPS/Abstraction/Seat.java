package LoveBabbarTasks.OOPS.Abstraction;

abstract class Seat {
    protected String seatNumber;
    protected int rowNumber;
    protected boolean available;

    Seat(String seatNumber, int rowNumber) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.available = true;
    }

    abstract double calculateSeatPrice();

    void reserve() {
        if (available) {
            available = false;
            System.out.println("Seat " + seatNumber + " reserved");
        } else {
            System.out.println("Seat " + seatNumber + " is already reserved");
        }
    }

    void release() {
        available = true;
        System.out.println("Seat " + seatNumber + " released");
    }
}
