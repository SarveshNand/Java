package LoveBabbarTasks.OOPS.Abstraction;

public class EmailNotification implements Notification{
    String recipientEmail;
    String subject;
    String body;

    EmailNotification(String recipientEmail, String subject, String body){
        this.recipientEmail = recipientEmail;
        this.subject = subject;
        this.body = body;
    }

    @Override
    public void send(){
        System.out.println("Sending Email to: " + recipientEmail);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
    }
}
