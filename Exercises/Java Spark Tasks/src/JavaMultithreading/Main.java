package JavaMultithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    static Callable<String> loadProfile = () -> {
        Thread.sleep(2000);
        return "Profile Loaded";
    };
    static Callable<String> loadOrders = () -> {
        Thread.sleep(3000);
        return "Orders loaded";
    };
    static Callable<String> loadWallet = () -> {
        Thread.sleep(1000);
        return "Wallet loaded";
    };

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        NumberThread t1 = new NumberThread();
//        NumberThread t2 = new NumberThread();
//        t1.start();
//        t2.start();
//        Is output order fixed? -> No


//        EmailTask task = new EmailTask();
//        Thread t3 = new Thread(task, "Thread-1");
//        Thread t4 = new Thread(task, "Thread-2");
//        Thread t5 = new Thread(task, "Thread-3");
//        t3.start();
//        t4.start();
//        t5.start();


//        MyThread thread = new MyThread();
//        thread.run();
//        thread.start();


//        DownloadThread downloadThread = new DownloadThread();
//        downloadThread.start();
//        downloadThread.join();
//        System.out.println("Processing downloaded file");


//        PaymentTask paymentTask = new PaymentTask();
//        InvoiceTask invoiceTask = new InvoiceTask();
//        EmailTask emailTask = new EmailTask();
//
//        paymentTask.start();
//        paymentTask.join();
//
//        invoiceTask.start();
//        invoiceTask.join();
//
//        emailTask.start();
//        emailTask.join();


//        Counter counter = new Counter();
//        Thread t1 = new Thread(() -> {
//            for (int i =0; i<10000; i++){
//                counter.increment();
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            for (int i =0; i<10000; i++){
//                counter.increment();
//            }
//        });
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//        System.out.println("Final count: " + counter.count);


//        TicketBooking booking = new TicketBooking();
//        Thread rahul = new Thread(() -> {
//            booking.bookTicket("Rahul");
//        });
//        Thread priya = new Thread(() -> {
//            booking.bookTicket("Priya");
//        });
//        priya.start();
//        rahul.start();


//        TicketBookingReentrant booking = new TicketBookingReentrant();
//        Thread rahul = new Thread(() -> {
//            booking.bookTicket("Rahul");
//        });
//        Thread priya = new Thread(() -> {
//            booking.bookTicket("Priya");
//        });
//        rahul.start();
//        priya.start();


//        Wallet wallet = new Wallet();
//        Thread t1 = new Thread(() -> {
//            wallet.debit("Rahul", 3000);
//        });
//        Thread t2 = new Thread(() -> {
//            wallet.debit("Priya", 3000);
//        });
//        t1.start();
//        t2.start();


//        String[] emails = {
//                "rahul@gmail.com",
//                "priya@gmail.com",
//                "amit@gmail.com",
//                "neha@gmail.com",
//                "rohit@gmail.com",
//                "sneha@gmail.com",
//                "vikas@gmail.com",
//                "anjali@gmail.com",
//                "arjun@gmail.com",
//                "pooja@gmail.com"
//        };
//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        for (String email: emails){
//            executor.submit(() -> {
//                System.out.println("Sending email to " + email + " by " + Thread.currentThread().getName());
//            });
//        }
//        executor.shutdown();


//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.submit(() -> System.out.println("Order created"));
//        executorService.submit(() -> System.out.println("Payment completed"));
//        executorService.submit(() -> System.out.println("Invoice generated"));
//        executorService.submit(() -> System.out.println("Email sent"));
//        executorService.shutdown();


//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
////        scheduler.schedule(() -> System.out.println("Checking payment status"), 3, TimeUnit.SECONDS);
////        scheduler.shutdown();
//        scheduler.scheduleAtFixedRate(() -> System.out.println("Checking payment status"), 0, 5, TimeUnit.SECONDS);


//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        MarksCalculator calculator = new MarksCalculator();
//        Future<Integer> future = executor.submit(calculator);
//        System.out.println("Total marks: " + future.get());
//        executor.shutdown();


//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        PaymentStatusTask paymentStatusTask = new PaymentStatusTask("ORD101");
//        Future<String> future = executorService.submit(paymentStatusTask);
//        System.out.println(future.get());
//        executorService.shutdown();


//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Future<String> profile = executorService.submit(loadProfile);
//        Future<String> orders = executorService.submit(loadOrders);
//        Future<String> wallet = executorService.submit(loadWallet);
//        System.out.println(profile.get());
//        System.out.println(orders.get());
//        System.out.println(wallet.get());
//        System.out.println("Dashboard ready");
//        executorService.shutdown();


//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        Callable<Integer> totalStudents = () -> 500;
//        Callable<Integer> totalCourses = () -> 25;
//        Callable<Integer> totalPayments = () -> 1000;
//        List<Callable<Integer>> tasks = Arrays.asList(
//                totalStudents,
//                totalCourses,
//                totalPayments
//        );
//        List<Future<Integer>> results = executor.invokeAll(tasks);
//        System.out.println("Total students: " + results.get(0).get());
//        System.out.println("Total courses: " + results.get(1).get());
//        System.out.println("Total payments: " + results.get(2).get());
//        executor.shutdown();


//        ExecutorService executor = Executors.newFixedThreadPool(3);
//        Callable<String> providerA = () -> {
//            Thread.sleep(2000);
//            return "Provider A: ₹500";
//        };
//        Callable<String> providerB = () -> {
//            Thread.sleep(1000);
//            return "Provider B: ₹450";
//        };
//        Callable<String> providerC = () -> {
//            Thread.sleep(3000);
//            return "Provider C: ₹480";
//        };
//        List<Callable<String>> providers = Arrays.asList(
//                providerA,
//                providerB,
//                providerC
//        );
//        String result = executor.invokeAny(providers);
//        System.out.println("First successful result: " + result);
//        executor.shutdown();



        Order order = new Order(101, "Rahul", 5000);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            Payment paymentTask = new Payment(order);
            Future<String> paymentFuture = executor.submit(paymentTask);

            String paymentResult = paymentFuture.get();
            System.out.println(paymentResult);

            if (paymentResult.startsWith("Payment SUCCESS")) {
                Invoice invoiceTask = new Invoice(order);
                Future<String> invoiceFuture = executor.submit(invoiceTask);

                String invoiceResult = invoiceFuture.get();
                System.out.println(invoiceResult);

                if (invoiceResult.startsWith("Invoice generated")) {
                    executor.submit(new Email(order)).get();
                }
            }
            System.out.println("Order processing completed");
        } finally {
            executor.shutdown();
        }
    }
}
