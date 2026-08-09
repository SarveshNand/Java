package LoveBabbarTasks.OOPS.Abstraction;

public class Scooter extends DeliveryVehicle implements LocationTrackable{

    Scooter(String registrationId, String brand, double startingCharge) {
        super(registrationId, brand, startingCharge);
    }

    @Override
    double computeCharge(double distance) {
        return getStartingCharge() + distance * 8;
    }

    @Override
    public void getCurrentLocation() {
        System.out.println("Getting scooter location");
    }

    @Override
    public void updateLocation() {
        System.out.println("Updating scooter location");
    }
}
