package JavaMultithreading;

import java.util.concurrent.Callable;

public class Invoice implements Callable<String> {
    private Order order;

    public Invoice(Order order) {
        this.order = order;
    }

    @Override
    public String call() {
        String threadName = Thread.currentThread().getName();
        return "Invoice generated for order " + order.getOrderId() + " by " + threadName;
    }
}
