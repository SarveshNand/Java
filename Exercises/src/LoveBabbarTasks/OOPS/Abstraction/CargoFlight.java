package LoveBabbarTasks.OOPS.Abstraction;

import java.time.LocalDateTime;

public class CargoFlight extends Flight implements CargoCarrier{
    private double cargoWeight;

    CargoFlight(String flightNumber, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, double cargoWeight) {
        super(flightNumber, source, destination, departureTime, arrivalTime);
        this.cargoWeight = cargoWeight;
    }

    @Override
    double calculatePrice() {
        return cargoWeight * 100;
    }

    @Override
    public void loadCargo() {
        System.out.println("Loading " + cargoWeight + " kg cargo");
    }
}
