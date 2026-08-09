package LoveBabbarTasks.OOPS.Abstraction;

class PaymentViaNetBanking implements Payments {
    private PaymentStatus status = PaymentStatus.PENDING;

    @Override
    public void pay(double amount) {
        status = PaymentStatus.SUCCESS;
        System.out.println("Paid ₹" + amount + " using Net Banking");
    }

    @Override
    public void refund(double amount) {
        status = PaymentStatus.REFUNDED;
        System.out.println("Refunded ₹" + amount + " through Net Banking");
    }

    @Override
    public PaymentStatus checkStatus() {
        return status;
    }
}