package LoveBabbarTasks.OOPS.Abstraction;

import java.time.LocalDateTime;

abstract class Flight implements Trackable{
    protected String flightNumber;
    protected String source;
    protected String destination;
    protected LocalDateTime departureTime;
    protected LocalDateTime arrivalTime;

    Flight(String flightNumber, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
    }

    abstract double calculatePrice();

    double calculateDuration() {
        long minutes = java.time.Duration.between(departureTime, arrivalTime).toMinutes();
        return minutes / 60.0;
    }

    void checkAvailability() {
        System.out.println("Seats available on flight " + flightNumber);
    }

    void schedule() {
        System.out.println("Flight " + flightNumber + " scheduled");
    }

    void cancel() {
        System.out.println("Flight " + flightNumber + " cancelled");
    }

    @Override
    public String getCurrentLocation() {
        return "Between " + source + " and " + destination;
    }
}
