package LoveBabbarTasks.OOPS.Abstraction;

import java.time.LocalDateTime;

public class DomesticFlight extends Flight{
    DomesticFlight(String flightNumber, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        super(flightNumber, source, destination, departureTime, arrivalTime);
    }

    @Override
    double calculatePrice() {
        return 5000;
    }
}
