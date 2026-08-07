package LoveBabbarTasks.OOPS.Inheritance;

public class Staff {
    int id;
    String name;

    public Staff(){}

    public Staff(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void login(){
        System.out.println(name + " logged in successfully.");
    }
}
