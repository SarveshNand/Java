package LoveBabbarTasks.OOPS.Inheritance;

public class Burger extends FoodItem{
    String type;

    Burger(String name, double price, String type){
        super(name, price);
        this.type = type;
    }

    @Override
    public void showMenu(){
        super.showMenu();
        System.out.println("Type: " + type);
    }
}
