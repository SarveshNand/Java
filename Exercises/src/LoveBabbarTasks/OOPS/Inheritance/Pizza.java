package LoveBabbarTasks.OOPS.Inheritance;

public class Pizza extends FoodItem{
    String crustType;

    public Pizza(String name, double price, String crustType){
        super(name, price);
        this.crustType = crustType;
    }

    @Override
    public void showMenu(){
        super.showMenu();
        System.out.println("Crust Type: " + crustType);
    }
}
