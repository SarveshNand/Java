package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
//        Payment payment1 = new CreditCardPayment(new BigDecimal(5000), "CC101");
//        Payment payment2 = new UPIPayment(new BigDecimal(2000), "UPI101");
//        Payment payment3 = new PayPalPayment(new BigDecimal(3000), "PP101");
//        Payment payment4 = new CashOnDelivery(new BigDecimal(1500), "COD101");
//        payment1.pay();
//        payment1.checkStatus();
//        payment1.refund();
//        payment1.checkStatus();
//        System.out.println();
//        payment2.pay();
//        payment2.checkStatus();
//        System.out.println();
//        payment3.pay();
//        payment3.checkStatus();
//        System.out.println();
//        payment4.pay();
//        payment4.checkStatus();


//        Car car = new Car("Toyota", "Camry", 50, 80);
//        System.out.println("===== CAR =====");
//        car.start();
//        car.accelerate();
//        car.brake();
//        car.openDoors();
//        car.useAC();
//        car.stop();
//
//        Bike bike = new Bike("Honda", "CBR", 40, 60);
//        System.out.println("\n===== BIKE =====");
//        bike.start();
//        bike.accelerate();
//        bike.brake();
//        bike.kickStart();
//        bike.useStand();
//        bike.stop();
//
//        Bus bus = new Bus("Volvo", "9400", 30, 90);
//        System.out.println("\n===== BUS =====");
//        bus.start();
//        bus.accelerate();
//        bus.brake();
//        bus.openPassengerDoors();
//        bus.announceStop();
//        bus.stop();
//
//        ElectricCar electricCar =
//                new ElectricCar("Tesla", "Model 3", 60, 0);
//        System.out.println("\n===== ELECTRIC CAR =====");
//        electricCar.start();
//        electricCar.accelerate();
//        electricCar.brake();
//        electricCar.regenerativeBrake();
//        electricCar.charge();
//        System.out.println("Battery: "
//                + electricCar.getBatteryLevel() + "%");
//        electricCar.stop();


//        Customer customer = new Customer("Rahul", 9876543210L, "Delhi");
//        DeliveryPartner partner = new DeliveryPartner("Amit", 9876543211L, 1234);
//        RestaurantOwner owner = new RestaurantOwner("Rohit", 9876543212L, "Pizza House");
//        Admin admin = new Admin("Admin", 9876543213L, 101);
//
//        System.out.println("===== CUSTOMER =====");
//        customer.login();
//        customer.placeOrder();
//        customer.trackOrder();
//        customer.cancelOrder();
//        customer.logout();
//
//        System.out.println("\n===== DELIVERY PARTNER =====");
//        partner.login();
//        partner.acceptDelivery();
//        partner.pickUpOrder();
//        partner.deliverOrder();
//        partner.logout();
//
//        System.out.println("\n===== RESTAURANT OWNER =====");
//        owner.login();
//        owner.addFoodItem();
//        owner.removeFoodItem();
//        owner.updateMenu();
//        owner.logout();
//
//        System.out.println("\n===== ADMIN =====");
//        admin.login();
//        admin.manageUsers();
//        admin.manageOrders();
//        admin.blockUsers();
//        admin.logout();
//
//        FoodOrder foodOrder = new FoodOrder(101, 599.50, "Pizza House");
//        GroceryOrder groceryOrder = new GroceryOrder(102, 1299.00, "Reliance Fresh");
//
//        System.out.println("\n===== FOOD ORDER =====");
//        foodOrder.placeOrder();
//        foodOrder.trackOrder();
//        foodOrder.calculateDeliveryTime();
//        foodOrder.addFoodItem();
//        foodOrder.cancelOrder();
//
//        System.out.println("\n===== GROCERY ORDER =====");
//        groceryOrder.placeOrder();
//        groceryOrder.trackOrder();
//        groceryOrder.calculateDeliveryTime();
//        groceryOrder.substituteItem();
//        groceryOrder.handleOutOfStock();
//        groceryOrder.cancelOrder();


//        EmailNotification email = new EmailNotification("rahul@gmail.com", "Order Confirmed", "Your order has been confirmed.");
//        SMSNotification sms = new SMSNotification(9876543210l, "Your order has been shipped.");
//        WhatsAppNotification whatsapp = new WhatsAppNotification(9876543210l, "Your delivery partner is on the way.");
//        PushNotification push = new PushNotification("DEVICE123", "Order Update", "Your order is arriving soon.");
//
//        email.send();
//        System.out.println();
//        sms.send();
//        System.out.println();
//        whatsapp.send();
//        System.out.println();
//        push.send();


//        Electronics laptop = new Electronics(101, "Laptop", 80000, 2);
//        Clothing shirt = new Clothing(102, "T-Shirt", 1500, 5);
//        Grocery rice = new Grocery(103, "Rice Bag", 1200, 10);
//        Furniture sofa = new Furniture(104, "Sofa", 50000, 1);
//
//        System.out.println("===== ELECTRONICS =====");
//        laptop.displayDetails();
//        System.out.println("Discount: " + laptop.calculateDiscount());
//        System.out.println("Shipping: " + laptop.calculateShippingCost());
//
//        System.out.println("\n===== CLOTHING =====");
//        shirt.displayDetails();
//        System.out.println("Discount: " + shirt.calculateDiscount());
//        System.out.println("Shipping: " + shirt.calculateShippingCost());
//
//        System.out.println("\n===== GROCERY =====");
//        rice.displayDetails();
//        System.out.println("Discount: " + rice.calculateDiscount());
//        System.out.println("Shipping: " + rice.calculateShippingCost());
//
//        System.out.println("\n===== FURNITURE =====");
//        sofa.displayDetails();
//        System.out.println("Shipping: " + sofa.calculateShippingCost());


//        SavingsAccount savings = new SavingsAccount("SA101", "Rahul", 10000, 5);
//        CurrentAccount current = new CurrentAccount("CA101", "Amit", 5000, 10000);
//        SalaryAccount salary = new SalaryAccount("SAL101", "Rohit", 30000);
//
//        System.out.println("===== SAVINGS ACCOUNT =====");
//        savings.deposit(2000);
//        savings.withdraw(3000);
//        savings.displayBalance();
//        System.out.println("Interest: " + savings.calculateInterest());
//
//        System.out.println("\n===== CURRENT ACCOUNT =====");
//        current.deposit(5000);
//        current.withdraw(15000);
//        current.displayBalance();
//        System.out.println("Overdraft Limit: " + current.getOverdraftLimit());
//
//        System.out.println("\n===== SALARY ACCOUNT =====");
//        salary.creditSalary(50000);
//        salary.withdraw(10000);
//        salary.displayBalance();


        DeliveryVehicle cycle = new Cycle("CYC101", "Hero", 20);
        DeliveryVehicle scooter = new Scooter("SCO101", "Honda", 30);
        DeliveryVehicle hatchback = new Hatchback("HAT101", "Maruti", 50);
        DeliveryVehicle van = new Van("VAN101", "Tata", 80);

        System.out.println("===== CYCLE =====");
        cycle.displayDetails();
        System.out.println("Charge for 10 km: ₹" + cycle.computeCharge(10));
        cycle.beginDelivery();
        cycle.endDelivery();

        System.out.println("\n===== SCOOTER =====");
        scooter.displayDetails();
        System.out.println("Charge for 10 km: ₹" + scooter.computeCharge(10));
        scooter.beginDelivery();
        scooter.endDelivery();

        System.out.println("\n===== HATCHBACK =====");
        hatchback.displayDetails();
        System.out.println("Charge for 10 km: ₹" + hatchback.computeCharge(10));

        System.out.println("\n===== VAN =====");
        van.displayDetails();
        System.out.println("Charge for 10 km: ₹" + van.computeCharge(10));

        System.out.println("\n===== GPS TEST =====");
        LocationTrackable tracker = new Scooter("SCO102", "TVS", 40);
        tracker.getCurrentLocation();
        tracker.updateLocation();

        System.out.println("\n===== PAYMENT TEST =====");
        PaymentService payment = new PaymentService();
        payment.processTransaction(250);

        System.out.println("\n===== CUSTOMER TEST =====");
        Client client = new Client("Rahul", 9876543210L, "Delhi");
        client.login();
        client.placeOrder();
        client.trackDelivery();
        client.cancelOrder();
        client.logout();

        System.out.println("\n===== DELIVERY PARTNER TEST =====");
        DeliveryVehicle deliveryVehicle = new Scooter("DL01AB1234", "Honda", 30);
        DeliveryMediator partner = new DeliveryMediator("Amit", 9876501234L, deliveryVehicle);
        partner.login();
        partner.acceptDelivery();
        partner.startDelivery();
        partner.completeDelivery();
        partner.logout();
    }
}
