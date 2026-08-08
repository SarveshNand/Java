package LoveBabbarTasks.OOPS.Polymorphism;

public class Truck extends Vehicle{
    int loadCapacity;
    int numberOfWheels;

    Truck(int vehicleNumber, String brand, double baseRatePerDay, int loadCapacity, int numberOfWheels){
        super(vehicleNumber, brand, baseRatePerDay);
        this.loadCapacity = loadCapacity;
        this.numberOfWheels = numberOfWheels;
    }

    @Override
    double calculateRent(int days){
        double rent = baseRatePerDay * days;
        rent += (loadCapacity/1000) * 1000 * days;
        return rent;
    }
}
