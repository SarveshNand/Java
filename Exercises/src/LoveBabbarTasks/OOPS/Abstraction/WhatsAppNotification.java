package LoveBabbarTasks.OOPS.Abstraction;

public class WhatsAppNotification implements Notification{
    long phoneNumber;
    String message;

    WhatsAppNotification(long phoneNumber, String message){
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    @Override
    public void send(){
        System.out.println("Sending WhatsApp message to: " + phoneNumber);
        System.out.println("Message: " + message);
    }
}
