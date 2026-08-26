package JavaMultithreading;

public class PaymentTask extends Thread{
    @Override
    public void run(){
        System.out.println("Payment Completed");
    }
}
