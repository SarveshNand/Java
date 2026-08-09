package LoveBabbarTasks.OOPS.Abstraction;

public class CabinCrew extends People{
    CabinCrew(String name, int age, long phoneNumber, String email) {
        super(name, age, phoneNumber, email);
    }

    void servePassengers() {
        System.out.println(name + " is serving passengers");
    }

    void handleEmergency() {
        System.out.println(name + " is handling an emergency");
    }
}
