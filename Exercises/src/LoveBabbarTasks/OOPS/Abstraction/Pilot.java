package LoveBabbarTasks.OOPS.Abstraction;

public class Pilot extends People{
    private String licenseNumber;

    Pilot(String name, int age, long phoneNumber, String email, String licenseNumber){
        super(name, age, phoneNumber, email);
        this.licenseNumber = licenseNumber;
    }

    void flyAircraft() {
        System.out.println(name + " is flying the aircraft");
    }

    void performPreFlightCheck() {
        System.out.println(name + " performed pre-flight check");
    }
}
