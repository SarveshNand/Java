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


//        Notification[] notifications = new Notification[4];
//        notifications[0] = new EmailNotification("Hello Rahul", "Rahul", "Welcome Email");
//        notifications[1] = new SMSNotification("Your OTP is 1234", "Aman", 9876543210l);
//        notifications[2] = new PushNotification("You have a new message", "Priya", "DEVICE123");
//        notifications[3] = new WhatsappNotification("Your order has been shipped", "Rohit", 9876543210l);
//
//        for (Notification notification : notifications){
//            notification.send();
//            System.out.println("-------------------------");
//        }


//        FoodItem[] order = new FoodItem[4];
//        order[0] = new Pizza("Farmhouse Pizza", 300, 2, "Large", "Extra Cheese");
//        order[1] = new Burger("Chicken Burger", 200, 1, "Chicken", true);
//        order[2] = new Biryani("Chicken Biryani", 250, 2, "Chicken", "Large");
//        order[3] = new Dessert("Ice Cream", 100, 2, "Vanilla", true);
//
//        for (FoodItem item : order){
//            item.displayDetails();
//            System.out.println("Calculated Price: " + item.calculatePrice());
//            item.prepare();
//            System.out.println("-------------------------");
//        }


//        Vehicle[] vehicles = new Vehicle[3];
//        vehicles[0] = new Car(101, "Toyota", 2000, 5, true);
//        vehicles[1] = new Bike(102, "Honda", 800, 150, true);
//        vehicles[2] = new Truck(103, "Tata", 5000, 5000, 6);
//        int days = 3;
//        for (Vehicle vehicle: vehicles){
//            System.out.println("Brand: " + vehicle.brand);
//            System.out.println("Rent for " + days + " days: " + vehicle.calculateRent(days));
//            vehicle.start();
//            vehicle.stop();
//            System.out.println("-------------------------");
//        }


//        BankAccount[] accounts = new BankAccount[3];
//        accounts[0] = new SavingsAccount(1001, "Rahul", 50000, 5);
//        accounts[1] = new CurrentAccount(1002, "Aman", 30000, 10000);
//        accounts[2] = new SalaryAccount(1003, "Priya", 40000, "Google");
//        for (BankAccount account: accounts){
//            System.out.println("Balance: " + account.displayBalance());
//            System.out.println("Interest: " + account.calculateInterest());
//            System.out.println("-------------------------");
//        }


//        HealthCareProfessional[] professionals = new HealthCareProfessional[4];
//        professionals[0] = new Doctor("Rahul", 101, "Cardiology", "Cardiologist");
//        professionals[1] = new Nurse("Priya", 102, "Emergency", "Night");
//        professionals[2] = new Surgeon("Aman", 103, "Surgery", "Orthopedic Surgeon", 50);
//        professionals[3] = new Physiotherapist("Neha", 104, "Physiotherapy", "Sports");
//        for (HealthCareProfessional professional: professionals){
//            professional.displayDetails();
//            professional.work();
//            System.out.println("-------------------------");
//        }


        Product[] products = new Product[4];
        products[0] = new Electronics(101, "Laptop", 50000, 2.5, "Dell", 24);
        products[1] = new Clothing(102, "T-Shirt", 2000, 0.5, "L", "Cotton");
        products[2] = new Food(103, "Biryani", 500, 1.0, "2026/08/10", true);
        products[3] = new Book(104, "Java Programming", 1000, 0.8, "James Gosling", 500);
        for (Product product: products){
            System.out.println("Product: " + product.name);
            System.out.println("Discount: ₹" + product.calculateDiscount());
            System.out.println("Tax: ₹" + product.calculateTax());
            System.out.println("Shipping: ₹" + product.calculateShippingCost());
            System.out.println("Return Policy: " + product.getReturnPolicy());
            System.out.println("-------------------------");
        }
    }
}
