package LoveBabbarTasks.OOPS.Polymorphism;

public class PushNotification extends Notification{
    String deviceId;

    PushNotification(String message, String recipient, String deviceId){
        super(message, recipient);
        this.deviceId = deviceId;
    }

    @Override
    void send(){
        System.out.println(message + " has been sent to " + recipient + " on the device id " + deviceId);
    }
}
