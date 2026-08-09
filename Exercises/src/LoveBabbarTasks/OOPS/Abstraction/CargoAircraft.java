package LoveBabbarTasks.OOPS.Abstraction;

class CargoAircraft extends Aircraft implements CargoCarrier {

    CargoAircraft(String aircraftId, String model, int capacity, double fuelCapacity, double currentFuel) {
        super(aircraftId, model, capacity, fuelCapacity, currentFuel);
    }

    @Override
    public void loadCargo() {
        System.out.println("Loading cargo into " + model);
    }
}
