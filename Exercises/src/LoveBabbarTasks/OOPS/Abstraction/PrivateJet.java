package LoveBabbarTasks.OOPS.Abstraction;

class PrivateJet extends Aircraft implements PassengerCarrier {

    PrivateJet(String aircraftId, String model, int capacity, double fuelCapacity, double currentFuel) {
        super(aircraftId, model, capacity, fuelCapacity, currentFuel);
    }

    @Override
    public void boardPassengers() {
        System.out.println("Boarding private passengers");
    }
}
