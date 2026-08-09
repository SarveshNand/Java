package LoveBabbarTasks.OOPS.Abstraction;

class PaymentViaWallet implements Payments {
    private PaymentStatus status = PaymentStatus.PENDING;

    @Override
    public void pay(double amount) {

        status = PaymentStatus.SUCCESS;
        System.out.println("Paid ₹" + amount + " using Wallet");
    }

    @Override
    public void refund(double amount) {
        status = PaymentStatus.REFUNDED;
        System.out.println("Refunded ₹" + amount + " to Wallet");
    }

    @Override
    public PaymentStatus checkStatus() {
        return status;
    }
}