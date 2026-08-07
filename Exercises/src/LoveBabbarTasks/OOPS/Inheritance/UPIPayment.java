package LoveBabbarTasks.OOPS.Inheritance;

class UPIPayment extends Payment{
    String upiId;

    UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    void pay() {
        System.out.println("Paid ₹" + amount + " using UPI.");
        System.out.println("UPI ID: " + upiId);
    }
}
