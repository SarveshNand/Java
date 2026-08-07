package LoveBabbarTasks.OOPS.Inheritance;

class AutoRide extends Ride{
    AutoRide(String pickupLocation, String destination) {
        super(pickupLocation, destination);
    }

    void calculateFare(double distance) {
        fare = distance * 15; // ₹15 per km
        System.out.println("Auto fare calculated.");
    }
}
