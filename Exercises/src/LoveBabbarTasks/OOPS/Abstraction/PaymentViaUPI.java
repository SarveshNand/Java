package LoveBabbarTasks.OOPS.Abstraction;

class PaymentViaUPI implements Payments {
    private PaymentStatus status = PaymentStatus.PENDING;

    @Override
    public void pay(double amount) {
        status = PaymentStatus.SUCCESS;
        System.out.println("Paid ₹" + amount + " using UPI");
    }

    @Override
    public void refund(double amount) {
        status = PaymentStatus.REFUNDED;
        System.out.println("Refunded ₹" + amount + " through UPI");
    }

    @Override
    public PaymentStatus checkStatus() {
        return status;
    }
}