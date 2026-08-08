package LoveBabbarTasks.OOPS.Polymorphism;

public class Notification {
    String message;
    String recipient;

    Notification(String message, String recipient){
        this.message = message;
        this.recipient = recipient;
    }

    void send(){
        System.out.println(message + " has been sent to " + recipient);
    }
}
