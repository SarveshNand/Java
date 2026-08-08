package LoveBabbarTasks.OOPS.Polymorphism;

public class Car extends Vehicle{
    int numberOfSeats;
    boolean hasAC;

    Car(int vehicleNumber, String brand, double baseRatePerDay, int numberOfSeats, boolean hasAC){
        super(vehicleNumber, brand, baseRatePerDay);
        this.numberOfSeats = numberOfSeats;
        this.hasAC = hasAC;
    }

    @Override
    double calculateRent(int days){
        double rent = baseRatePerDay * days;

        if (hasAC){
            rent += 500 * days;
        }
        return rent;
    }
}
