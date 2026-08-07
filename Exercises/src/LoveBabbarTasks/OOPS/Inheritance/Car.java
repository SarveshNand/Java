package LoveBabbarTasks.OOPS.Inheritance;

public class Car extends Vehicle{
    public Car(String brand, int speed){
        super(brand, speed);
    }

    public void openTrunk(){
        System.out.println("The trunk has been open.");
    }
}
