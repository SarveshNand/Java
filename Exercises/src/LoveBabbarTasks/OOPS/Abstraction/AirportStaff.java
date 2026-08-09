package LoveBabbarTasks.OOPS.Abstraction;

public class AirportStaff extends People{
    AirportStaff(String name, int age, long phoneNumber, String email) {
        super(name, age, phoneNumber, email);
    }

    void verifyDocuments() {
        System.out.println(name + " verified documents");
    }

    void manageBoarding() {
        System.out.println(name + " is managing boarding");
    }
}
