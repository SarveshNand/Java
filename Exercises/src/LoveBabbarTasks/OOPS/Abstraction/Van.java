package LoveBabbarTasks.OOPS.Abstraction;

public class Van extends DeliveryVehicle{

    Van(String registrationId, String brand, double startingCharge) {
        super(registrationId, brand, startingCharge);
    }

    @Override
    double computeCharge(double distance) {
        return getStartingCharge() + distance * 20;
    }
}
