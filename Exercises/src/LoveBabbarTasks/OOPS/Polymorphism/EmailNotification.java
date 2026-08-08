package LoveBabbarTasks.OOPS.Polymorphism;

public class EmailNotification extends Notification{
    String emailSubject;

    EmailNotification(String message, String recipient, String emailSubject){
        super(message, recipient);
        this.emailSubject = emailSubject;
    }

    @Override
    void send(){
        System.out.println(message + " has been sent to " + recipient + " via email subject of " + emailSubject);
    }
}
