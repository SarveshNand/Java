package LoveBabbarTasks.OOPS.Inheritance;

class BikeRide extends Ride{
    BikeRide(String pickupLocation, String destination) {
        super(pickupLocation, destination);
    }

    void calculateFare(double distance){
        fare = distance * 10; // ₹10 per km
        System.out.println("Bike fare calculated.");
    }
}
