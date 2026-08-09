package LoveBabbarTasks.OOPS.Abstraction;

class Bike extends Vehicle{

    Bike(String brand, String model, int speed, double fuelLevel){
        super(brand, model, speed, fuelLevel);
    }

    @Override
    void start(){
        System.out.println("Bike starts using engine");
    }

    void kickStart(){
        System.out.println("Starting Bike by kicking");
    }

    void useStand(){
        System.out.println("Bike is standing via bike stand");
    }
}
