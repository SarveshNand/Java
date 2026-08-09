package LoveBabbarTasks.OOPS.Abstraction;

class PaymentViaCard implements Payments {
    private PaymentStatus status = PaymentStatus.PENDING;

    @Override
    public void pay(double amount) {
        status = PaymentStatus.SUCCESS;
        System.out.println("Paid ₹" + amount + " using Credit/Debit Card");
    }

    @Override
    public void refund(double amount) {
        status = PaymentStatus.REFUNDED;
        System.out.println("Refunded ₹" + amount + " to Card");
    }

    @Override
    public PaymentStatus checkStatus() {
        return status;
    }
}
