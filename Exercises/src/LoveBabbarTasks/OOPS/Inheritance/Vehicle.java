package LoveBabbarTasks.OOPS.Inheritance;

public class Vehicle {
    public String brand;
    public int speed;

    public Vehicle(){}

    public Vehicle(String brand, int speed){
        this.brand = brand;
        this.speed = speed;
    }

    public void start(){
        System.out.println("Vehicle is starting.");
    }
    public void stop(){
        System.out.println("Vehicle is stopping.");
    }
}
