package JavaMultithreading;

public class InvoiceTask extends Thread{
    @Override
    public void run(){
        System.out.println("Invoice Generated");
    }
}
