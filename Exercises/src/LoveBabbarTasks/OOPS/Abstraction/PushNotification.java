package LoveBabbarTasks.OOPS.Abstraction;

public class PushNotification implements Notification{
    String deviceToken;
    String title;
    String message;

    PushNotification(String deviceToken, String title, String message){
        this.deviceToken = deviceToken;
        this.title = title;
        this.message = message;
    }

    @Override
    public void send(){
        System.out.println("Sending Push Notification to: " + deviceToken);
        System.out.println("Title: " + title);
        System.out.println("Message: " + message);
    }
}
