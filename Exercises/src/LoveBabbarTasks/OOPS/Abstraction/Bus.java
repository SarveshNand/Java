package LoveBabbarTasks.OOPS.Abstraction;

class Bus extends Vehicle{

    Bus(String brand, String model, int speed, double fuelLevel){
        super(brand, model, speed, fuelLevel);
    }

    @Override
    void start(){
        System.out.println("Bus starts using engine");
    }

    void openPassengerDoors(){
        System.out.println("Bus doors opened");
    }

    void announceStop(){
        System.out.println("Announcing that bus is going to stop");
    }
}
