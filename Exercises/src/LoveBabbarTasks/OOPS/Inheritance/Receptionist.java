package LoveBabbarTasks.OOPS.Inheritance;

public class Receptionist extends Staff{
    Receptionist(int id, String name){
        super(id, name);
    }

    void duty(){
        System.out.println("Receptionist is managing appointments.");
    }
}
