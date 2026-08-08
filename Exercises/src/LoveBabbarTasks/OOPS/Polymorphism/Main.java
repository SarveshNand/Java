package LoveBabbarTasks.OOPS.Polymorphism;

public class Main {
    public static void main(String[] args) {
//        Payment payment = new CreditCardPayment(5000, "TXN101", 123456, "Rahul");
//        payment.pay();
//        payment.generateReceipt();
//        System.out.println("-------------------------");
//        payment = new UPIPayment(1500, "TXN102", "rahul@upi");
//        payment.pay();
//        payment.generateReceipt();
//        System.out.println("-------------------------");
//        payment = new CashOnDeliveryPayment(2500, "TXN103", "Delhi");
//        payment.pay();
//        payment.generateReceipt();

//        Employee[] employees = new Employee[3];
//        employees[0] = new FullTimeEmployee("Rahul", 101, 50000, 5000);
//        employees[1] = new PartTimeEmployee("Aman", 102, 80, 500);
//        employees[2] = new Freelancer("Priya", 103, 100000, 10);
//
//        for (Employee employee : employees){
//            employee.displayDetails();
//            System.out.println("--------------------");
//        }


        Notification[] notifications = new Notification[4];
        notifications[0] = new EmailNotification("Hello Rahul", "Rahul", "Welcome Email");
        notifications[1] = new SMSNotification("Your OTP is 1234", "Aman", 9876543210l);
        notifications[2] = new PushNotification("You have a new message", "Priya", "DEVICE123");
        notifications[3] = new WhatsappNotification("Your order has been shipped", "Rohit", 9876543210l);

        for (Notification notification : notifications){
            notification.send();
            System.out.println("-------------------------");
        }
    }
}
