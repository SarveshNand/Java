package LoveBabbarTasks.OOPS.Abstraction;

class EmergencyExitSeat extends Seat implements WeightRestricted {

    EmergencyExitSeat(String seatNumber, int rowNumber) {
        super(seatNumber, rowNumber);
    }

    @Override
    double calculateSeatPrice() {
        return 1000;
    }

    @Override
    public boolean checkWeightLimit() {
        System.out.println("Checking emergency seat eligibility");
        return true;
    }
}