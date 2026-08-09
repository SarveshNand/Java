package LoveBabbarTasks.OOPS.Abstraction;

class Car extends Vehicle{

    Car(String brand, String model, int speed, double fuelLevel){
        super(brand, model, speed, fuelLevel);
    }

    @Override
    void start(){
        System.out.println("Car starts using engine");
    }

    void openDoors(){
        System.out.println("Opening Car door");
    }

    void useAC(){
        System.out.println("Using Car AC");
    }
}
