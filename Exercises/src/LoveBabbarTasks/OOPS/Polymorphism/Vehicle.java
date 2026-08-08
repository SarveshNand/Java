package LoveBabbarTasks.OOPS.Polymorphism;

public class Vehicle {
    int vehicleNumber;
    String brand;
    double baseRatePerDay;

    Vehicle(int vehicleNumber, String brand, double baseRatePerDay){
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.baseRatePerDay = baseRatePerDay;
    }

    double calculateRent(int days){
        return baseRatePerDay * days;
    }

    void start(){
        System.out.println("Starting " + brand);
    }

    void stop(){
        System.out.println("Stopping " + brand);
    }
}
