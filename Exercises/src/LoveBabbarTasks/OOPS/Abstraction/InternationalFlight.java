package LoveBabbarTasks.OOPS.Abstraction;

import java.time.LocalDateTime;

public class InternationalFlight extends Flight{
    private double internationalTax;

    InternationalFlight(String flightNumber, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, double internationalTax) {
        super(flightNumber, source, destination, departureTime, arrivalTime);
        this.internationalTax = internationalTax;
    }

    @Override
    double calculatePrice() {
        return 12000 + internationalTax;
    }

    double calculateInternationalTax() {
        return internationalTax;
    }
}
