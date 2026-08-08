package LoveBabbarTasks.OOPS.Polymorphism;

public class Bike extends Vehicle{
    int engineCC;
    boolean hasHelmet;

    Bike(int vehicleNumber, String brand, double baseRatePerDay, int engineCC, boolean hasHelmet){
        super(vehicleNumber, brand, baseRatePerDay);
        this.engineCC = engineCC;
        this.hasHelmet = hasHelmet;
    }

    @Override
    double calculateRent(int days){
        double rent = baseRatePerDay * days;

        if (hasHelmet){
            rent += 100 * days;
        }
        return rent;
    }
}
