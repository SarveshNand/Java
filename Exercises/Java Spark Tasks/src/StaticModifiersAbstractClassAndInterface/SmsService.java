package StaticModifiersAbstractClassAndInterface;

public class SmsService implements NotificationService{
    @Override
    public void send(String message){
        System.out.println("SMS: " + message);
    }
}
