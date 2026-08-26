package JavaMultithreading;

import java.util.concurrent.Callable;

public class PaymentStatusTask implements Callable<String> {
    private final String orderId;

    PaymentStatusTask(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String call() {
        return "Payment SUCCESS for order " + orderId;
    }
}
