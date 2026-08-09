package LoveBabbarTasks.OOPS.Abstraction;

public class Hatchback extends DeliveryVehicle{

    Hatchback(String registrationId, String brand, double startingCharge) {
        super(registrationId, brand, startingCharge);
    }

    @Override
    double computeCharge(double distance) {
        return getStartingCharge() + distance * 15;
    }
}
