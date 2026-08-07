package LoveBabbarTasks.OOPS.Inheritance;

public class Drink extends FoodItem{
    int volume;

    Drink(String name, double price, int volume){
        super(name, price);
        this.volume = volume;
    }

    @Override
    public void showMenu(){
        super.showMenu();
        System.out.println("Volume: " + volume + " ml");
    }
}
