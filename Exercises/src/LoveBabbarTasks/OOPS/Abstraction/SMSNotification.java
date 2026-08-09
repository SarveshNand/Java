package LoveBabbarTasks.OOPS.Abstraction;

public class SMSNotification implements Notification{
    long phoneNumber;
    String message;

    SMSNotification(long phoneNumber, String message){
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public void send(){
        System.out.println("Sending SMS to: " + phoneNumber);
        System.out.println("Message: " + message);
    }
}
