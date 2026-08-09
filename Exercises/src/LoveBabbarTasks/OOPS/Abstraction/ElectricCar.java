package LoveBabbarTasks.OOPS.Abstraction;

class ElectricCar extends Vehicle implements ElectricVehicle{

    ElectricCar(String brand, String model, int speed, double fuelLevel){
        super(brand, model, speed, fuelLevel);
    }

    @Override
    void start(){
        System.out.println("Electric car starts using electric motor");
    }

    @Override
    public void charge(){
        System.out.println("Charging battery");
    }

    @Override
    public int getBatteryLevel(){
        return 80;
    }

    void regenerativeBrake(){
        System.out.println("Charging Battery when applying the brake at the same time");
    }
}
