package LoveBabbarTasks.OOPS.Inheritance;

public class Bike extends Vehicle{
    public Bike(String brand, int speed){
        super(brand, speed);
    }

    public void wheelie(){
        System.out.println("Doing wheelie!!!");
    }
}
