package LoveBabbarTasks.OOPS.Polymorphism;

public class SMSNotification extends Notification{
    long phoneNumber;

    SMSNotification(String message, String recipient, long phoneNumber){
        super(message, recipient);
        this.phoneNumber = phoneNumber;
    }

    @Override
    void send(){
        System.out.println(message + " has been sent to " + recipient + " on the phone number " + phoneNumber);
    }
}
