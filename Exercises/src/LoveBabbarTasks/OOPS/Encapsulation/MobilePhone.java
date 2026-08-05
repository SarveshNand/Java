package LoveBabbarTasks.OOPS.Encapsulation;

public class MobilePhone {
    private String brand;
    private String model;
    private int batteryPercentage;

    public MobilePhone(String brand, String model, int batteryPercentage){
        this.brand = brand;
        this.model = model;
        if (batteryPercentage < 0) {
            this.batteryPercentage = 0;
        } else if (batteryPercentage > 100) {
            this.batteryPercentage = 100;
        } else {
            this.batteryPercentage = batteryPercentage;
        }
    }

    public void charge(int chargeValue){
        if (chargeValue > 0){
            batteryPercentage += chargeValue;
            if (batteryPercentage > 100){
                batteryPercentage = 100;
            }
        }
    }

    public void usePhone(int usage){
        if (usage > 0){
            batteryPercentage -= usage;
            if (batteryPercentage < 0){
                batteryPercentage = 0;
            }
        }
    }

    public void displayBattery(){
        System.out.println("Battery: " + batteryPercentage + "%");
    }
}
