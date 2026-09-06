package threadSynchronization;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    public static void main(String[] args) {

        Worker worker = new Worker(0, 5);

        Thread producer = new Thread(() -> {
            try {
                worker.produce();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                worker.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}

class Worker {

    private int sequence = 0;

    private final Integer top;
    private final Integer bottom;
    private final List<Integer> container;

    private final Object lock = new Object();

    public Worker(Integer bottom, Integer top) {
        this.bottom = bottom;
        this.top = top;
        this.container = new ArrayList<>();
    }

    public void produce() throws InterruptedException {

        while (true) {

            synchronized (lock) {

                while (container.size() == top) {
                    System.out.println(
                            "Container full, waiting for items to be removed..."
                    );

                    lock.wait();
                }

                System.out.println(sequence + " Added to the container");

                container.add(sequence++);

                lock.notifyAll();
            }

            Thread.sleep(500);
        }
    }

    public void consume() throws InterruptedException {

        while (true) {

            synchronized (lock) {

                while (container.size() == bottom) {
                    System.out.println(
                            "Container empty, waiting for items to be added..."
                    );

                    lock.wait();
                }

                System.out.println(
                        container.removeFirst() + " removed from the container"
                );

                lock.notifyAll();
            }

            Thread.sleep(500);
        }
    }
}