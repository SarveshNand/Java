package LoveBabbarTasks.OOPS.Inheritance;

class CabRide extends Ride{
    CabRide(String pickupLocation, String destination) {
        super(pickupLocation, destination);
    }

    void calculateFare(double distance){
        fare = distance * 20; // ₹20 per km
        System.out.println("Cab fare calculated.");
    }
}
