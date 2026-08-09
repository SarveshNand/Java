package LoveBabbarTasks.OOPS.Abstraction;

public class DeliveryMediator extends Person{
    DeliveryVehicle vehicle;

    DeliveryMediator(String name, long phone, DeliveryVehicle vehicle) {
        super(name, phone);
        this.vehicle = vehicle;
    }

    void acceptDelivery() {
        System.out.println(name + " accepted the delivery");
    }

    void startDelivery() {
        vehicle.beginDelivery();
    }

    void completeDelivery() {
        vehicle.endDelivery();
    }
}
