package JavaMultithreading;

import java.util.concurrent.Callable;

public class Payment implements Callable<String> {
    private Order order;

    public Payment(Order order) {
        this.order = order;
    }

    @Override
    public String call() {
        String threadName = Thread.currentThread().getName();
        return "Payment SUCCESS for order " + order.getOrderId() + " by " + threadName;
    }
}
