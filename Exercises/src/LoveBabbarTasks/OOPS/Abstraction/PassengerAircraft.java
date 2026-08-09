package LoveBabbarTasks.OOPS.Abstraction;

public class PassengerAircraft extends Aircraft implements PassengerCarrier{
    PassengerAircraft(String aircraftId, String model, int capacity, double fuelCapacity, double currentFuel) {
        super(aircraftId, model, capacity, fuelCapacity, currentFuel);
    }

    @Override
    public void boardPassengers() {
        System.out.println("Boarding passengers into " + model);
    }
}
