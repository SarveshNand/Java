package JavaMultithreading;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("Running on: " + Thread.currentThread().getName());
    }
}
