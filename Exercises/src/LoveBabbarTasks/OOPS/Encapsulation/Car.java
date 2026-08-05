package LoveBabbarTasks.OOPS.Encapsulation;

public class Car {
    private int fuel;
    private int speed;
    private boolean engineOn;

    public Car(int fuel, int speed){
        this.fuel = Math.max(fuel, 0);
        this.speed = Math.max(speed, 0);
        this.engineOn = false;
    }

    public void startEngine(){
        if (fuel <= 0){
            System.out.println("Cannot start engine. No fuel.");
            engineOn = false;
            return;
        } else {
            engineOn = true;
            System.out.println("Engine Started.");
        }
    }
    public void stopEngine(){
        engineOn = false;
        System.out.println("Engine Stopped.");
    }
    public void accelerate(int value){
        if (!engineOn){
            System.out.println("Engine isn't On");
            return;
        }
        if (value <= 0){
            return;
        }
        if (fuel < value){
            System.out.println("Not enough fuel.");
            return;
        }
        speed += value;
        fuel -= value;
    }

    public void brake(int value){
        speed -= value;
        if (speed < 0){
            speed = 0;
        }
    }

    public void showStatus() {
        System.out.println("Fuel: " + fuel);
        System.out.println("Speed: " + speed);
        System.out.println("Engine On: " + engineOn);
    }
}
