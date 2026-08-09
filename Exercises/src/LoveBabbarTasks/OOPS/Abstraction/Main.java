package LoveBabbarTasks.OOPS.Abstraction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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


//        DeliveryVehicle cycle = new Cycle("CYC101", "Hero", 20);
//        DeliveryVehicle scooter = new Scooter("SCO101", "Honda", 30);
//        DeliveryVehicle hatchback = new Hatchback("HAT101", "Maruti", 50);
//        DeliveryVehicle van = new Van("VAN101", "Tata", 80);
//
//        System.out.println("===== CYCLE =====");
//        cycle.displayDetails();
//        System.out.println("Charge for 10 km: ₹" + cycle.computeCharge(10));
//        cycle.beginDelivery();
//        cycle.endDelivery();
//
//        System.out.println("\n===== SCOOTER =====");
//        scooter.displayDetails();
//        System.out.println("Charge for 10 km: ₹" + scooter.computeCharge(10));
//        scooter.beginDelivery();
//        scooter.endDelivery();
//
//        System.out.println("\n===== HATCHBACK =====");
//        hatchback.displayDetails();
//        System.out.println("Charge for 10 km: ₹" + hatchback.computeCharge(10));
//
//        System.out.println("\n===== VAN =====");
//        van.displayDetails();
//        System.out.println("Charge for 10 km: ₹" + van.computeCharge(10));
//
//        System.out.println("\n===== GPS TEST =====");
//        LocationTrackable tracker = new Scooter("SCO102", "TVS", 40);
//        tracker.getCurrentLocation();
//        tracker.updateLocation();
//
//        System.out.println("\n===== PAYMENT TEST =====");
//        PaymentService payment = new PaymentService();
//        payment.processTransaction(250);
//
//        System.out.println("\n===== CUSTOMER TEST =====");
//        Client client = new Client("Rahul", 9876543210L, "Delhi");
//        client.login();
//        client.placeOrder();
//        client.trackDelivery();
//        client.cancelOrder();
//        client.logout();
//
//        System.out.println("\n===== DELIVERY PARTNER TEST =====");
//        DeliveryVehicle deliveryVehicle = new Scooter("DL01AB1234", "Honda", 30);
//        DeliveryMediator partner = new DeliveryMediator("Amit", 9876501234L, deliveryVehicle);
//        partner.login();
//        partner.acceptDelivery();
//        partner.startDelivery();
//        partner.completeDelivery();
//        partner.logout();

        System.out.println("\n===== PEOPLE =====");
        Passenger passenger = new Passenger("Rahul", 25, 9876543210L, "rahul@gmail.com", "P123456");
        Pilot pilot = new Pilot("Amit", 40, 9876500000L, "amit@airline.com", "LIC123");
        CabinCrew crew = new CabinCrew("Priya", 28, 9876511111L, "priya@airline.com");
        AirportStaff staff = new AirportStaff("Ravi", 35, 9876522222L, "ravi@airport.com");

        passenger.login();
        passenger.bookFlight();

        pilot.login();
        pilot.performPreFlightCheck();
        pilot.flyAircraft();

        crew.login();
        crew.servePassengers();

        staff.login();
        staff.verifyDocuments();

        System.out.println("\n===== FLIGHTS =====");
        Flight domesticFlight = new DomesticFlight("AI101", "Delhi", "Mumbai", LocalDateTime.of(2026, 8, 10, 10, 0), LocalDateTime.of(2026, 8, 10, 12, 30));
        Flight internationalFlight = new InternationalFlight("AI202", "Delhi", "London", LocalDateTime.of(2026, 8, 10, 18, 0), LocalDateTime.of(2026, 8, 11, 6, 0), 5000);
        Flight cargoFlight = new CargoFlight("CARGO301", "Delhi", "Dubai", LocalDateTime.of(2026, 8, 10, 20, 0), LocalDateTime.of(2026, 8, 11, 2, 0), 1000);

        System.out.println("Domestic price: ₹" + domesticFlight.calculatePrice());
        System.out.println("International price: ₹" + internationalFlight.calculatePrice());
        System.out.println("Cargo price: ₹" + cargoFlight.calculatePrice());
        System.out.println("Domestic duration: " + domesticFlight.calculateDuration() + " hours");

        domesticFlight.checkAvailability();
        domesticFlight.schedule();

        System.out.println("Current location: " + domesticFlight.getCurrentLocation());

        System.out.println("\n===== AIRCRAFT =====");
        PassengerAircraft boeing737 = new PassengerAircraft("AC001", "Boeing 737", 180, 26000, 10000);
        CargoAircraft boeing777 = new CargoAircraft("AC002", "Boeing 777 Cargo", 0, 180000, 50000);
        PrivateJet jet = new PrivateJet("AC003", "Gulfstream G650", 20, 48000, 20000);

        boeing737.startEngine();
        boeing737.boardPassengers();
        boeing737.takeOff();
        boeing737.land();
        boeing737.refuel(5000);

        boeing777.startEngine();
        boeing777.loadCargo();

        jet.startEngine();
        jet.boardPassengers();

        System.out.println("\n===== SEATS =====");
        Seat economySeat = new EconomySeat("12A", 12);
        Seat businessSeat = new BusinessSeat("4A", 4);
        Seat firstClassSeat = new FirstClassSeat("1A", 1);
        EmergencyExitSeat emergencySeat = new EmergencyExitSeat("15A", 15);

        System.out.println("Economy seat price: ₹" + economySeat.calculateSeatPrice());
        System.out.println("Business seat price: ₹" + businessSeat.calculateSeatPrice());
        System.out.println("First class seat price: ₹" + firstClassSeat.calculateSeatPrice());

        economySeat.reserve();
        economySeat.release();

        emergencySeat.checkWeightLimit();
        emergencySeat.reserve();

        System.out.println("\n===== BOOKINGS =====");
        Booking economyBooking = new EconomyBooking("B001", passenger, domesticFlight, new EconomySeat("20A", 20));
        Booking businessBooking = new BusinessBooking("B002", passenger, domesticFlight, new BusinessSeat("5A", 5));
        Booking firstBooking = new FirstClassBooking("B003", passenger, internationalFlight, new FirstClassSeat("1A", 1));

        economyBooking.displayBooking();
        economyBooking.confirm();
        economyBooking.generateTicket();
        System.out.println("Economy refund: ₹" + ((Refundable) economyBooking).calculateRefund());

        businessBooking.displayBooking();
        firstBooking.displayBooking();

        System.out.println("\n===== PAYMENTS =====");
        Payments cardPayment = new PaymentViaCard();
        Payments upiPayment = new PaymentViaUPI();
        Payments netBankingPayment = new PaymentViaNetBanking();
        Payments walletPayment = new PaymentViaWallet();

        cardPayment.pay(7500);
        System.out.println("Card status: " + cardPayment.checkStatus());

        cardPayment.refund(2000);
        upiPayment.pay(5000);
        System.out.println("UPI status: " + upiPayment.checkStatus());

        netBankingPayment.pay(10000);
        walletPayment.pay(1500);

        System.out.println("\n===== BAGGAGE =====");
        Baggage cabinBaggage = new CabinBaggage("BG001", 6, passenger);
        Baggage checkedBaggage = new CheckedBaggage("BG002", 20, passenger);
        Baggage oversizedBaggage = new OversizedBaggage("BG003", 35, passenger);

        cabinBaggage.generateTag();
        cabinBaggage.displayDetails();

        checkedBaggage.generateTag();
        checkedBaggage.displayDetails();

        oversizedBaggage.generateTag();
        oversizedBaggage.displayDetails();

        System.out.println("\n===== INTERFACE POLYMORPHISM =====");
        Trackable trackableFlight = domesticFlight;
        System.out.println(trackableFlight.getCurrentLocation());

        Refundable refundableBooking = new BusinessBooking("B004", passenger, domesticFlight, new BusinessSeat("6A", 6));
        System.out.println("Refund amount: ₹" + refundableBooking.calculateRefund());

        PassengerCarrier passengerCarrier = boeing737;
        passengerCarrier.boardPassengers();

        CargoCarrier cargoCarrier = boeing777;
        cargoCarrier.loadCargo();

        Refuelable refuelable = boeing737;
        refuelable.refuel(2000);

        WeightRestricted weightRestricted = new CabinBaggage("BG004", 5, passenger);
        System.out.println("Within weight limit: " + weightRestricted.checkWeightLimit());

        System.out.println("\n===== COMPLETE BOOKING FLOW =====");
        Passenger newPassenger = new Passenger("Neha", 27, 9999999999L, "neha@gmail.com", "P987654");
        Flight flight = new DomesticFlight("AI505", "Bangalore", "Delhi", LocalDateTime.of(2026, 8, 15, 9, 0), LocalDateTime.of(2026, 8, 15, 12, 0));

        Seat seat = new EconomySeat("18B", 18);
        Booking booking = new EconomyBooking("BOOK505", newPassenger, flight, seat);
        System.out.println("Total fare: ₹" + booking.calculateFare());
        booking.confirm();

        Payments payment = new PaymentViaUPI();
        payment.pay(booking.calculateFare());
        booking.generateTicket();
        System.out.println("Payment status: " + payment.checkStatus());
    }
}
