package LoveBabbarTasks.OOPS.Intro;

public class Car {
//    Attributes
    public String brand;
    public String model;
    public long price;
//    Methods
    public Car(String brand, String model, long price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    public void displayCar(){
        System.out.println("Inside displayCar()");
        System.out.println("Brand of the car: " + this.brand);
        System.out.println("Model of the car: " + this.model);
        System.out.println("Price of the car: ₹" + this.price);
    }
}
