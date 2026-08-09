package LoveBabbarTasks.OOPS.Abstraction;

public class Cycle extends DeliveryVehicle{

    Cycle(String registrationId, String brand, double startingCharge) {
        super(registrationId, brand, startingCharge);
    }

    @Override
    double computeCharge(double distance) {
        return getStartingCharge() + distance * 5;
    }
}
