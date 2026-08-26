package JavaMultithreading;

public class EmailTask extends Thread{
    @Override
    public void run(){
        System.out.println("Email Sent");
    }
}
