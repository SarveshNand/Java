package LoveBabbarTasks.OOPS.Inheritance;

class Ride {
    String pickupLocation;
    String destination;
    double fare;

    Ride(String pickupLocation, String destination){
        this.pickupLocation = pickupLocation;
        this.destination = destination;
    }

    void startRide(){
        System.out.println("Ride started from " + pickupLocation + " to " + destination);
    }

    void endRide(){
        System.out.println("Ride ended. Total fare: ₹" + fare);
    }
}
