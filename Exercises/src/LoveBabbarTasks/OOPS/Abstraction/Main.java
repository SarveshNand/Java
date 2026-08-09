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


        Car car = new Car("Toyota", "Camry", 50, 80);
        System.out.println("===== CAR =====");
        car.start();
        car.accelerate();
        car.brake();
        car.openDoors();
        car.useAC();
        car.stop();

        Bike bike = new Bike("Honda", "CBR", 40, 60);
        System.out.println("\n===== BIKE =====");
        bike.start();
        bike.accelerate();
        bike.brake();
        bike.kickStart();
        bike.useStand();
        bike.stop();

        Bus bus = new Bus("Volvo", "9400", 30, 90);
        System.out.println("\n===== BUS =====");
        bus.start();
        bus.accelerate();
        bus.brake();
        bus.openPassengerDoors();
        bus.announceStop();
        bus.stop();

        ElectricCar electricCar =
                new ElectricCar("Tesla", "Model 3", 60, 0);
        System.out.println("\n===== ELECTRIC CAR =====");
        electricCar.start();
        electricCar.accelerate();
        electricCar.brake();
        electricCar.regenerativeBrake();
        electricCar.charge();
        System.out.println("Battery: "
                + electricCar.getBatteryLevel() + "%");
        electricCar.stop();
    }
}
