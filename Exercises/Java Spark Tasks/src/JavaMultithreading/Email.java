package JavaMultithreading;

public class Email implements Runnable {
    private Order order;

    public Email(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Email sent to " + order.getCustomerName() + " by " + threadName);
    }
}
