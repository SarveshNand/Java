package LoveBabbarTasks.OOPS.Abstraction;

public class Passenger extends People{
    private String passportNumber;

    Passenger(String name, int age, long phoneNumber, String email, String passportNumber) {
        super(name, age, phoneNumber, email);
        this.passportNumber = passportNumber;
    }

    void bookFlight() {
        System.out.println(name + " booked a flight");
    }

    void cancelBooking() {
        System.out.println(name + " cancelled a booking");
    }

    String getPassportNumber() {
        return passportNumber;
    }
}
