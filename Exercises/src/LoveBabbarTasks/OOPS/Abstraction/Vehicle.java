package LoveBabbarTasks.OOPS.Abstraction;

abstract class Vehicle {
    String brand;
    String model;
    int speed;
    double fuelLevel;

    Vehicle(String brand, String model, int speed, double fuelLevel){
        this.brand = brand;
        this.model = model;
        this.speed = speed;
        this.fuelLevel = fuelLevel;
    }

    abstract void start();

    void stop(){
        speed = 0;
        System.out.println("Vehicle stopped");
    }

    void accelerate(){
        speed += 10;
        System.out.println("Vehicle accelerated");
    }

    void brake(){
        speed -= 10;
        if (speed < 0) speed = 0;
        System.out.println("Vehicle braking");
    }
}
