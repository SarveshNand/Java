package LoveBabbarTasks.OOPS.Abstraction;

interface Payments {
    void pay(double amount);
    void refund(double amount);
    PaymentStatus checkStatus();
}
