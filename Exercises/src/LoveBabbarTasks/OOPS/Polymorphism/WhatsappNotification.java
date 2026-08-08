package LoveBabbarTasks.OOPS.Polymorphism;

public class WhatsappNotification extends Notification{
    long whatsappNumber;

    WhatsappNotification(String message, String recipient, long whatsappNumber){
        super(message, recipient);
        this.whatsappNumber = whatsappNumber;
    }

    @Override
    void send(){
        System.out.println(message + " has been sent to " + recipient + " on the whatsapp number " + whatsappNumber);
    }
}
