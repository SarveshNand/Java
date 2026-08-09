package LoveBabbarTasks.OOPS.Abstraction;

abstract class Aircraft implements Refuelable{
    protected String aircraftId;
    protected String model;
    protected int capacity;
    protected double fuelCapacity;
    protected double currentFuel;

    Aircraft(String aircraftId, String model, int capacity, double fuelCapacity, double currentFuel) {
        this.aircraftId = aircraftId;
        this.model = model;
        this.capacity = capacity;
        this.fuelCapacity = fuelCapacity;
        this.currentFuel = currentFuel;
    }

    void startEngine() {
        System.out.println(model + " engine started");
    }

    void takeOff() {
        System.out.println(model + " taking off");
    }

    void land() {
        System.out.println(model + " landing");
    }

    @Override
    public void refuel(double amount) {
        currentFuel += amount;
        if (currentFuel > fuelCapacity) {currentFuel = fuelCapacity;}
        System.out.println(model + " refueled. Current fuel: " + currentFuel);
    }
}
