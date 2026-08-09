package LoveBabbarTasks.OOPS.Abstraction;

class DeliveryPartner extends User{
    int vehicleNumber;

    DeliveryPartner(String name, long phone, int vehicleNumber){
        super(name, phone);
        this.vehicleNumber = vehicleNumber;
    }

    void acceptDelivery(){
        System.out.println("Delivery accepted");
    }

    void pickUpOrder(){
        System.out.println("Order picked up");
    }

    void deliverOrder(){
        System.out.println("Order delivered");
    }
}
