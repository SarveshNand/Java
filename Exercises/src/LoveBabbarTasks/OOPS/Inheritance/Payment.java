package LoveBabbarTasks.OOPS.Inheritance;

class Payment {
    double amount;

    Payment (double amount){
        this.amount = amount;
    }

    void pay(){
        System.out.println("Payment of ₹" + amount + " completed.");
    }
}
