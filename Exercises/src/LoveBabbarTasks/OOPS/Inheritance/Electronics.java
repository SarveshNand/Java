package LoveBabbarTasks.OOPS.Inheritance;

public class Electronics extends Product{
    public Electronics(String name, double price){
        super(name, price);
    }

    public void warrantyYears(int year){
        System.out.println("You've got " + year + " year(s) of warranty.");
    }
}
