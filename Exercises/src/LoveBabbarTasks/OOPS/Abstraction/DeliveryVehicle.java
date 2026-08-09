package LoveBabbarTasks.OOPS.Abstraction;

abstract class DeliveryVehicle {
    private String registrationId;
    private String brand;
    private double startingCharge;

    DeliveryVehicle(String registrationId, String brand, double startingCharge){
        this.registrationId = registrationId;
        this.brand = brand;
        this.startingCharge = startingCharge;
    }

    abstract double computeCharge(double distance);

    void beginDelivery(){
        System.out.println("Delivery started");
    }

    void endDelivery(){
        System.out.println("Delivery ended");
    }

    void displayDetails(){
        System.out.println("Registration ID: " + registrationId);
        System.out.println("Brand: " + brand);
        System.out.println("Starting Charge: " + startingCharge);
    }

    public String getBrand() {
        return brand;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public double getStartingCharge() {
        return startingCharge;
    }
}
