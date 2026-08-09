package LoveBabbarTasks.OOPS.Abstraction;

abstract class Baggage {
    protected String baggageId;
    protected double weight;
    protected Passenger passenger;

    Baggage(String baggageId, double weight, Passenger passenger) {
        this.baggageId = baggageId;
        this.weight = weight;
        this.passenger = passenger;
    }

    abstract double calculateFee();

    void generateTag() {
        System.out.println("Baggage tag generated: " + baggageId);
    }

    void displayDetails() {
        System.out.println("Baggage ID: " + baggageId);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Passenger: " + passenger.name);
        System.out.println("Fee: ₹" + calculateFee());
    }
}
